package hellojpa;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @Column(name = "PRODUCT_ID")
    private String id;

//    @Id
//    @GeneratedValue
//    @Column(name = "MEMBER_ID")
//    private Long Id;

    @Column(name = "USERNAME")
    private String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
