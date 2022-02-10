package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Product {


    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long Id;

    @Column(name = "USERNAME")
    private String username;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;

    }
}
