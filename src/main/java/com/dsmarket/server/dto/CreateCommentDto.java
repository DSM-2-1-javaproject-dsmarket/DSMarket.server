package com.dsmarket.server.dto;

import com.dsmarket.server.entities.account.Account;
import com.dsmarket.server.entities.comment.Comment;
import com.dsmarket.server.entities.post.Post;
import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class CreateCommentDto {

    private Integer postId;

    private Account wroteAccount;

    private Comment motherComment;

    private Post wrotePost;

    private Boolean isSecret;

    private String content;

}
