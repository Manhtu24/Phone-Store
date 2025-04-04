package com.MTlovec.Phone_Store.service;

import com.MTlovec.Phone_Store.constant.CloudinaryConstant;
import com.MTlovec.Phone_Store.exception.CloudinaryException;
import com.MTlovec.Phone_Store.utils.CloudinaryUtils;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryServiceImpl implements CloudinaryService{


    //WRONG METHOD NEED TO CHECK AGAIN
    @Override
    public Map<String, String> generateSignature(String folder) {
        long timestamp=System.currentTimeMillis()/1000;
        System.out.println(timestamp);
        String dataSign = "folder="+ folder + "&timestamp=" + timestamp;
        String signature= new HmacUtils(HmacAlgorithms.HMAC_SHA_1,CloudinaryConstant.API_SECRET).hmacHex(dataSign.getBytes(StandardCharsets.UTF_8));
        System.out.println(dataSign);
        System.out.println(CloudinaryConstant.API_SECRET);
        Map<String, String> response= new HashMap<>();
        response.put("timestamp",String.valueOf(timestamp));
        response.put("signature",signature);
        return response;
    }

    @Override
    public Map<String, Object> generateSignature2(String folder) {
        Cloudinary cloudinary=CloudinaryUtils.getCloudinary();
        long timestamp=System.currentTimeMillis()/1000;
        Map<String ,Object> params=ObjectUtils.asMap(
                "folder",folder,
                        "timestamp",timestamp
        );
        String signature=cloudinary.apiSignRequest(params,CloudinaryConstant.API_SECRET);
        params.put("signature",signature);
        return params;
    }

    @Override
    public boolean deleteImage(String publicId) throws IOException {
        Cloudinary cloudinary= CloudinaryUtils.getCloudinary();
        Map result= cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
        if(!(result.get("result").equals("ok")&&result!=null)){
            throw new CloudinaryException("Problem occurred in delete on Cloudinary.Please try again");
        }
        return true;
    }
}
