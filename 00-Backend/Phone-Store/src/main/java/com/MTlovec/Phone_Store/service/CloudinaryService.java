package com.MTlovec.Phone_Store.service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public interface CloudinaryService {
    Map<String, String> generateSignature(String folder);

    boolean deleteImage(String publicId) throws IOException;

    Map<String,Object>generateSignature2(String folder) throws NoSuchAlgorithmException, InvalidKeyException;

}
