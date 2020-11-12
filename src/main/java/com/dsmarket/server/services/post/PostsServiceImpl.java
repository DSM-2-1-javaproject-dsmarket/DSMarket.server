package com.dsmarket.server.services.post;


import com.dsmarket.server.entities.post.Post;
import com.dsmarket.server.entities.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostsServiceImpl implements PostsService {

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

    public List<Post> getPosts(Pageable pageable){
        return postRepository.findAll(pageable).toList();
    }
}
