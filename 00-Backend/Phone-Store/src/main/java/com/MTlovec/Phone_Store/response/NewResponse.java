package com.MTlovec.Phone_Store.response;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class NewResponse {
    private Long id;
    private String imageUrl;
    private LocalDateTime createAt;
    private String title;
    private String describe;
    private String description;
    private List <ImageResponse> imagesInsideDescription;
}
