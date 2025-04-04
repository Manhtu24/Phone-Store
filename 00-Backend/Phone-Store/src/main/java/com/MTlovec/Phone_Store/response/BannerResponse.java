package com.MTlovec.Phone_Store.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BannerResponse {
    private Long id;
    private String imageUrl;
    private String pageName;
    private String bannerType;
    private Integer imageOrder;
}
