package com.dsmarket.server.dto.request;


import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class UpdateCommentRequest {

    @NotNull
    private Boolean isSecret;

    @NotNull
    private String content;

}
