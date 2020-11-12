package com.dsmarket.server.services.post;

import com.dsmarket.server.entities.post.Post;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostsService {

    public Post createPost(CreatePostForm postInfo);

    public List<Post> getPosts(Pageable pageable);
}
