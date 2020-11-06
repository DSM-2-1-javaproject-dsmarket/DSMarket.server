package com.dsmarket.server.dto.request;

import lombok.Builder;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Builder
public class WritePostRequest {

    @NotEmpty
    private String tag;

    @NotEmpty
    private String item;

    @NotEmpty
    private Integer price;

    @NotEmpty
    private String post_user;

    @NotEmpty
    private Date post_date;

    @NotEmpty
    private Integer post_type;

}
