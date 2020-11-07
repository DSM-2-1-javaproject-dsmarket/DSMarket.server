package com.dsmarket.server.dto.request;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;


@Builder
@Getter
public class WritePostRequest {

    @NotEmpty
    private String tag;

    @NotEmpty
    private String item;

    private Integer price;

    private Integer postType;

}
