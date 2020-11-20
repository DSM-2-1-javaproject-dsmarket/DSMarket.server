package com.dsmarket.server.services.post;

import com.dsmarket.server.entities.account.Account;
import com.dsmarket.server.entities.post.Post;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {

    public Post createPost(CreatePostForm postInfo);

    public List<Post> getPosts(Pageable pageable);

    public Post getPost(Integer id);

    public void checkPostEditAuthorization(Account account, Post post);

    public void deletePost(Post post);

    public Post updatePost(Post post, CreatePostForm postInfo);
}