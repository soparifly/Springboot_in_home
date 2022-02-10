package hellojpa;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
/**
 * 속성
name :  필드와매핑할 테이블의 컬럼이름
 insertable : true/false 컬럼을 수정했을때 데이터베이스에 컬럼을 변경, 반영할지여부 (기본값 : true)
 nullable(DDL) : null 값 허용여부를 설정한다. 기본값(true) not null 제약 조건이 붙는다
 unique : 기본값 true 잘 사용하지않음, 컬럼에 unique 제약조건을 만들어주는데  이름이 랜덤으로 발생한다 엔티티에 적용하는걸로해결
 columnDefinition : 원하는 컬럼정보를 직접 설정
 

 */
@Entity
public class Member {
    @Id
    private Long id;
    @Column(name = "name")
    private String username;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    @Transient
    private int temp;

}