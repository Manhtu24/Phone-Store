package com.MTlovec.Phone_Store.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.nimbusds.jose.shaded.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ClientRegistrationRepository clientRegistrationRepository;

    @Value("${spring.security.oauth2.registration.google.client-id}")
    private String googleClientId;

    @Value("${spring.security.oauth2.registration.google.client-secret}")
    private String googleClientSecret;

    @Value("${spring.security.oauth2.registration.google.redirect-url}")
    private String googleRedirectUri;

    @Value("${spring.security.oauth2.registration.google.user-info-uri}")
    private String googleUserInfoUri;

    @Override
    public String generateAuthUrl(String loginType) {
        ClientRegistration clientRegistration=((InMemoryClientRegistrationRepository)clientRegistrationRepository)
                .findByRegistrationId(loginType);
        if(clientRegistration==null){
            throw  new IllegalArgumentException("Can not found registration with login type: "+loginType);
        }
        String rwRedirectUri=googleRedirectUri;
        String redirectUri=rwRedirectUri.replace("{baseUrl}","http://localhost:5173");
        return UriComponentsBuilder.fromUriString(clientRegistration.getProviderDetails().getAuthorizationUri())
                .queryParam("client_id",clientRegistration.getClientId())
                .queryParam("redirect_uri",redirectUri) //cai nay can modify
                .queryParam("response_type","code")
                .queryParam("scope",String.join(" ",clientRegistration.getScopes()))
                .queryParam("state", UUID.randomUUID().toString())
                .build()
                .toUriString();
    }

    @Override
    public Map<String, Object> authenticateAndFetchUser(String code, String loginType) throws IOException {
        RestTemplate restTemplate= new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        String accessToken;
        Gson gson=new Gson();
        switch (loginType.toLowerCase()){
            case "google":
                accessToken=new GoogleAuthorizationCodeTokenRequest(
                        new NetHttpTransport(),new GsonFactory(),
                        googleClientId,
                        googleClientSecret,
                        code,
                        googleRedirectUri
                ).execute().getAccessToken();
                restTemplate.getInterceptors().add((req,body,executionContext)->{
                    req.getHeaders().set("Authorization","Bearer "+accessToken);
                    return executionContext.execute(req,body);
                });
                //take user info from gg
                return new ObjectMapper().readValue(
                        restTemplate.getForEntity(googleUserInfoUri, String.class).getBody(),
                        new TypeReference<>() {} );
            //if need to expand like github or face
            default:
                return null;
        }
    }
}
