package com.cnu.devblog.model.request;

import com.cnu.devblog.entity.Post;
import com.cnu.devblog.model.type.Tag;
import lombok.Getter;

@Getter
public class PostRequest {
    private String title;
    private String contents;

    private Tag tag;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .contents(contents)
                .tag(tag)
                .build();
    }
}
