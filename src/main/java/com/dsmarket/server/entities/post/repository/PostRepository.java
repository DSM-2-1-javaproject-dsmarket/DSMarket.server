package com.dsmarket.server.entities.post.repository;

import com.dsmarket.server.entities.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
    Post save(Post post);

    Page<Post> findAll(Pageable pageable);

    @Override
    void delete(Post entity);
}
