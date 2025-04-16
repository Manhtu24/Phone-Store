package com.MTlovec.Phone_Store.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageRequest {
    private Long id;
    private String imageUrl;
    private  String publicId;
}
