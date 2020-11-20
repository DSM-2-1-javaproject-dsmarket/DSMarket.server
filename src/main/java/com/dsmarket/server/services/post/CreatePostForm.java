package com.dsmarket.server.services.post;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreatePostForm {

    private Integer postType;

    private String postAccountId;

    private Integer price;

    private String item;

    private String tag;

}
