package com.MTlovec.Phone_Store.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private String newsDescribe;

    @Lob
    private String description; //html format

    private String coverImageUrl; //this is url of image (take from FE);

    private String coverImagePublicId; //public id from cloudinary save to use in the future

    @OneToMany(cascade = CascadeType.REMOVE,orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinColumn(name = "related_id",referencedColumnName = "id")
    @Where(clause = "related_type='news'")
    private List<Image> images;

    private LocalDateTime createAt;
}
