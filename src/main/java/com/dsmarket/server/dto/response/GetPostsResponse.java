package com.dsmarket.server.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetPostsResponse {

    private Integer id;

    private Integer view;

    private String tag;

    private String item;

    private Integer price;

    private String postUser;

    private Date postDate;

    private Integer postType;

    private Boolean finished;

}
