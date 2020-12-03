package com.dsmarket.server.entities.account;

import com.dsmarket.server.entities.comment.Comment;
import com.dsmarket.server.entities.post.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    private String id;

    @Column(nullable = false)
    private String password;

    @Column(length = 20, nullable = false, unique = true)
    private String nickname;

    @Column(length = 40, nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "wroteAccount")
    private List<Comment> comments;

    @OneToMany(mappedBy = "wroteAccount")
    private List<Post> posts;

}
