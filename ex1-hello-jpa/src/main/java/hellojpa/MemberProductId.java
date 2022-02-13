package hellojpa;

import java.io.Serializable;

/**
 * 복합키를 위한 식별자클래스의 특징
 * 복합키는 별도의 식별자 클래스로 만들어야한다
 * Serializable을 구현해야한다
 * equals와 hashCode 메소드를 구현해야한다
 * 기본 생성자가 있어야한다.
 * 식별자 클래스는 public 이어야한다
 * @IdClass를 사용하는 방법이외에 @EmbeddedId를 사용하는 방법도 있다
 *
 *
 *
 */
public class MemberProductId implements Serializable {
    private String member; //MemberProduct.member와 연결
    private String product; //MemberProduct.product와 연결

    //hashCode and equals


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
