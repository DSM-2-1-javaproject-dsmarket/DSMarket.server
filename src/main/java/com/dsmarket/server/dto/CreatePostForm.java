package com.dsmarket.server.dto;


import com.dsmarket.server.entities.account.Account;
import com.dsmarket.server.entities.image.Image;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreatePostForm {

    private Integer postType;

    private Account postAccount;

    private Integer price;

    private String item;

    private String tag;

    private String content;

    private Image itemImage;

}
