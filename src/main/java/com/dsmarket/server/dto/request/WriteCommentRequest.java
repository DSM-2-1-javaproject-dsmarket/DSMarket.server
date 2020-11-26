package com.dsmarket.server.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
public class WriteCommentRequest {

    @NotNull
    private Integer postId;

    private Integer motherCommentId;

    @NotNull
    private Boolean isSecret;

    @NotEmpty
    @NotNull
    private String content;

}
