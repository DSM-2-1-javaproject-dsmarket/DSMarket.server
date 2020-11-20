package com.dsmarket.server.entities.post;


import com.dsmarket.server.entities.post.repository.PostRepository;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Builder
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
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
