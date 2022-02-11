package springbook.user.domain.tobispring;


/**
 * DAO
 * DAO - Data Acess Object
 * 데이터를 조회하거나 조작하는 기능을 전담하도록 만든 오브젝트
 *
 *
 *
 * 자바빈(JavaBean)
 * 자바 빈 규약을 따르는 오브젝트
 * 원래 비주얼 툴에서 조작가능한 컴포넌트를 말한다.
 * 자바의 주력 개발 플렛폼이 웹기반의 엔터프라이즈 방식으로 바뀌면서
 */
public class User {
    String id;
    String name;
    String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
