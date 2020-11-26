package com.dsmarket.server.dto.request;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.*;


@Builder
@Getter
public class WritePostRequest {

    @NotEmpty
    private String tag;

    @NotEmpty
    private String item;

    @NotNull
    @Min(0)
    private Integer price;

    @Min(0)
    @Max(2)
    private Integer postType;

    @NotEmpty
    @NotNull
    private String content;

}
