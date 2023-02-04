package com.cnu.devblog.entity;

import com.cnu.devblog.model.type.Tag;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity(name = "posts")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Setter
    private String title;

    @Column
    @Setter
    private String contents;

    @Enumerated(EnumType.STRING)
    private Tag tag;

    @Builder
    public Post(String title, String contents, Tag tag) {
        this.title = title;
        this.contents = contents;
        this.tag = tag;
    }
}
