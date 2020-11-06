package com.dsmarket.server.services.post;


import com.dsmarket.server.entities.post.Post;
import com.dsmarket.server.entities.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Integer WritePost(){
        Post newPost = Post.builder().build();

        postRepository.save(newPost);
        return newPost.getId();
    }

}
