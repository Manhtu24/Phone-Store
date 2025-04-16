package com.MTlovec.Phone_Store.model;
//THIS CLASS TO SAVE PUBLIC ID AND IMAGE URL OF NEWS, POLICY,SERVICE ,...FROM CKEDITOR


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    private String publicId;

    @Column(name = "related_type")
    private String relatedType; //post, policy,service,..??

    @Column( name="related_id")
    private Long relatedId;//FK

    private LocalDate createAt;
}
