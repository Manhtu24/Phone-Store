package com.MTlovec.Phone_Store.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageSectionResponse {
    private Long id;
    private String title;
    private String description;
    private String sectionGroup;
    List<ImageResponse> images;
}
