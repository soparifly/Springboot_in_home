package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String name;
    private int age;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<Order>();



//    @Column(name = "TEAM_ID")
//    private Long TeamId;


    public void setTeam(Team team) {
        this.team = team;


        // 무한 루프에 빠지지않도록 체크
        if (!team.getMembers().contains(this)) {
            team.getMembers().add(this);
        }
    }
//연관관계 주인 (외래키)
    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

//연관관계 주인 (외래키)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;


    @ManyToMany
    @JoinTable(name = "MEMBER_PRODUCT",
            joinColumns = @JoinColumn(name = "MEMBER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID")
    )
    private List<Product> products = new ArrayList<>();





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Team getTeam() {
        return team;
    }
}