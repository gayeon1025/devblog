package com.cnu.devblog.service;

import com.cnu.devblog.entity.Post;
import com.cnu.devblog.model.request.PostRequest;
import com.cnu.devblog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Post createPost(PostRequest postRequest) {
        return postRepository.save(postRequest.toEntity());
    }

    public Optional<Post> getPost(Integer id) {
        return postRepository.findById(id);
    }

    public Post updatePost(Integer id, PostRequest postRequest) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException()); //FIXME: ERROR_CODE 정의하기
        post.setTitle(postRequest.getTitle());
        post.setContents(postRequest.getContents());
        return postRepository.save(post);
    }

    public void deletePost(Integer id) {
        postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException()); //FIXME: ERROR_CODE 정의하기
        postRepository.deleteById(id);
    }

    public Page<Post> getPosts(Specification<Post> specification, Pageable pageable) {
        return postRepository.findAll(specification, pageable);
    }
}
