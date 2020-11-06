package com.dsmarket.server.entities.post;


import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

@Entity
@Getter
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer view;

    @Column
    private String tag;

    @Column(nullable = false)
    private String item;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String post_user;

    @Column(nullable = false)
    private Date post_date;

    @Column(nullable = false)
    private Integer post_type;

    @Column
    @ColumnDefault("false")
    private Boolean finished;

    public Post increaseView(){
        this.view += 1;

        return this;
    }

}
