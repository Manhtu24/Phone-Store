package com.MTlovec.Phone_Store.service;

import com.MTlovec.Phone_Store.constant.CloudinaryConstant;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryServiceImpl implements CloudinaryService{

    @Override
    public Map<String, String> generateSignature() {
        long timestamp=System.currentTimeMillis()/1000;
        String dataSign="timestamp"+timestamp;
        String signature= new HmacUtils("HmacSHA1", CloudinaryConstant.API_SECRET).hmacHex(dataSign);
        Map<String, String> response= new HashMap<>();
        response.put("timestamp",String.valueOf(timestamp));
        response.put("signature",signature);
        return  response;
    }
}
