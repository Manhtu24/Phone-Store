package com.MTlovec.Phone_Store.service;

import java.io.IOException;
import java.util.Map;

public interface AuthService {
    String generateAuthUrl(String loginType);

    Map<String ,Object>authenticateAndFetchUser(String code, String loginType) throws IOException;
}
