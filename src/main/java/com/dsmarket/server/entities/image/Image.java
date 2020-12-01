package com.dsmarket.server.entities.image;


import lombok.AllArgsConstructor;
import lombok.Getter;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@AllArgsConstructor
public class Image {

    @Id
    private String fileName;

}
