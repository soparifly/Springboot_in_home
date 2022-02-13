package hellojpa;

import org.hibernate.mapping.Join;

import javax.persistence.*;


/*
* 복합기본키
* 기본키가 member_id 와 product_id인 복합 기본키
* Jpa 에서 복합키를 사용하려면 별도의 식별자 클래스 생성
* 엔티티에 @IdClass 를 사용해서 식별자 클래스를 지정하면된다.
* MemberProductId.class 를 복합키를 위한 식별자 클래스로 사용한다
*
* 회원 상품은 회원과 상품의 기본키를 받아서 자신의 기본 키로 사용한다.
* 이렇게 부모테이블의 기본키를 받아서 자신의 기본키 + 외래키로 사용한것을
* 식별 관계라한다.
* */

@Entity
@IdClass(MemberProductId.class)
public class MemberProduct {
//기본키 @Id와 외래키 매핑 @JoinColumn을 동시에 사용해서 기본키 + 외래키를 한번에 매핑
//    @IdClass 사용 복합 기본키 매핑

    @Id
    @ManyToMany
    @JoinColumn(name = "MEMBER_ID")
    private Member member; //MemberProductId.member와 연결


    @Id
    @ManyToMany
    @JoinColumn(name = "PRODUCT_ID")
    private Product product; //MemberProductId.product와 연결
    private int orderAmount;



}
