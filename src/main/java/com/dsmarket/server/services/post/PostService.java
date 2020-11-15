package com.dsmarket.server.services.post;

import com.dsmarket.server.entities.account.Account;
import com.dsmarket.server.entities.post.Post;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {

    public Post createPost(CreatePostForm postInfo);

    public List<Post> getPosts(Pageable pageable);

    public Post getPost(Integer id);

    public void deletePost(Account account, Post post2delete);
}
