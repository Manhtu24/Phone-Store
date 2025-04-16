package com.MTlovec.Phone_Store.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImageResponse {
    public Long id;
    private String newsImageUrl;
    private String newsImagePublicId;
}
