package com.dsmarket.server.entities.post;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

@Entity
@Getter
@Builder
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
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
    private String postUser;

    @Column(nullable = false)
    private Date postDate;

    @Column(nullable = false)
    private Integer postType;

    @Column
    @ColumnDefault("false")
    private Boolean finished;

    public Post increaseView(){
        this.view += 1;

        return this;
    }

}
