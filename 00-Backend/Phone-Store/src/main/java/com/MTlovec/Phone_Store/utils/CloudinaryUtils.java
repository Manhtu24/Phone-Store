package com.MTlovec.Phone_Store.utils;

import com.MTlovec.Phone_Store.constant.CloudinaryConstant;
import com.cloudinary.Cloudinary;

import java.util.HashMap;
import java.util.Map;

public class CloudinaryUtils {
    private static Cloudinary cloudinary;

    static {
        Map<String,String> cloudinaryConfig=new HashMap<>();
        cloudinaryConfig.put("cloud_name", CloudinaryConstant.CLOUD_NAME);
        cloudinaryConfig.put("api_key", CloudinaryConstant.API_KEY);
        cloudinaryConfig.put("api_secret",CloudinaryConstant.API_SECRET);
        cloudinary= new Cloudinary(cloudinaryConfig);
    }

    public static Cloudinary getCloudinary(){
        return cloudinary;
    }
}
