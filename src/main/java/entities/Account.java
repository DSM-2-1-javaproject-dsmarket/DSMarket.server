package entities;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class Account {
    @Id
    private String id;

    @Column
    private String password;

    @Column
    private String nickName;

    @Column
    private String email;
}
