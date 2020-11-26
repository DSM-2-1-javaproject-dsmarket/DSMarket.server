package com.dsmarket.server.dto;


import com.dsmarket.server.entities.account.Account;
import com.dsmarket.server.entities.comment.Comment;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateCommentDto {

    private Integer id;

    private Integer postId;

    private Boolean isSecret;

    private String content;

    private Account wroteAccount;

    private Comment motherCommentId;
}
