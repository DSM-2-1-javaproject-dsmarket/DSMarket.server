package com.dsmarket.server.entities.post.repository;

import com.dsmarket.server.entities.post.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> {
    Post save(Post post);
}
