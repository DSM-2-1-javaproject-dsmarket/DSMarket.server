package com.dsmarket.server.services.post;


import com.dsmarket.server.entities.post.Post;
import com.dsmarket.server.entities.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    public Post createPost(CreatePostForm postInfo){

        Date now = new Date();

        Post newPost = Post
                .builder()
                .postDate(now)
                .postType(postInfo.getPostType())
                .postUser(postInfo.getPostAccountId())
                .price(postInfo.getPrice())
                .item(postInfo.getItem())
                .tag(postInfo.getTag())
                .build();

        return postRepository.save(newPost);
    }
}
