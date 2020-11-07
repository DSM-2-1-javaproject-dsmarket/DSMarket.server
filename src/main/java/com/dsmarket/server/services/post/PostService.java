package com.dsmarket.server.services.post;

import com.dsmarket.server.entities.post.Post;

public interface PostService {

    public Post createPost(CreatePostForm postInfo);

}
