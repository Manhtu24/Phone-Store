package com.MTlovec.Phone_Store.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewsRequest {
    private String title;
    private  String author;
    private String describe;
    private String description;
    private String coverImageUrl;
    private String publicId;
    List<ImageRequest> images;

}
