package com.dsmarket.server.dto.response;

import com.dsmarket.server.entities.account.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class  GetCommentResponse {

    private String content;

    private String postAccountId;

    private Integer motherCommentId;

}
