package org.example.dto.response;

import org.example.domain.Category;
import org.example.domain.Post;

public record PostGetResponse(
        Long id,
        String title,
        String content,
        Category category
) {
    public static PostGetResponse of(Post post, Category category) {
        return new PostGetResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                category
        );
    }
}
