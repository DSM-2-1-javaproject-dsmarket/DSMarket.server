package com.dsmarket.server.entities.comment;

import com.dsmarket.server.entities.account.Account;
import com.dsmarket.server.entities.post.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(nullable = false)
//    private Integer postId;
    @ManyToOne
    @JoinColumn(name = "wrote_post_id", referencedColumnName = "id", nullable = false)
    private Post wrotePost;

//    @Column(nullable = false)
//    private String wroteUserId;
    @ManyToOne
    @JoinColumn(name = "wrote_account_id", referencedColumnName = "id", nullable = false)
    private Account wroteAccount;

    @ManyToOne
    @JoinColumn(name = "mother_comment_id", referencedColumnName = "id", nullable = true)
    private Comment motherComment;
//    @Column(nullable = true)
//    private Integer motherCommentId;

    @Column(nullable = false)
    private Boolean isSecret;

    @Column(nullable = false)
    private String content;
}
