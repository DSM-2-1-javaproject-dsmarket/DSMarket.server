package com.dsmarket.server.dto.request;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


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

    private Integer postType;

}
