package hellojpa;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 속성
 * name :  필드와매핑할 테이블의 컬럼이름
 * insertable : true/false 컬럼을 수정했을때 데이터베이스에 컬럼을 변경, 반영할지여부 (기본값 : true)
 * nullable(DDL) : null 값 허용여부를 설정한다. 기본값(true) not null 제약 조건이 붙는다
 * unique : 기본값 true 잘 사용하지않음, 컬럼에 unique 제약조건을 만들어주는데  이름이 랜덤으로 발생한다 엔티티에 적용하는걸로 해결
 * columnDefinition : 원하는 컬럼정보를 직접 설정
 */
@Entity
@SequenceGenerator(name = "member_seq_generator"
,sequenceName = "member_eq")
/**
 * TABLE 전략
 * 키생성 전용 테이블을 하나 만들어서 데이터 베이스 시퀀스를 흉내내는 전략
 * 장점 : 모든 데이터베이스에 적용가능
 * 단점 : 성능
 *
 * 권장하는 식별자 전략
 * 기본키 제약조건: null 아님, 유일 , 변하면안됨
 * 미래까지 이조건을 만족하는 자연키는 찾기어렵다, 대리키(대체키)를 사용하자
 *
 * 권장 Long + 대체키 + 키 생성전략 사용
 */
public class Member {
    /**
     * Data base 기본키 매핑
     * //@Id, @GeneratedValue
     * Id 만 사용하면 직접할당
     * AutoIncrement 자동할당 @GeneratedValue
     * strategy 기본 방언 에맞춰서 생성됨 sequence
     * Table, sequence, Identity, Auto
     * IDENTITY  : 데이터베이스에 auto_Increment 등을 위임함
     * SEQUENCE : Id 값의 타입이 숫자일때 SEQUENCE 값을 자동할당함
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "member_seq_generator")
    private String id;
    @Column(name = "name", nullable = false)
    private String username;
    private Integer age;
    /**
     * STRING으로 사용함
     */
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    /**
     * 날짜타입을 위해서 사용
     * LocalDate, LocalDateTime을 사용할때는 생략 가능
     */
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;
    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;
    //  최종 수정시간 날짜매핑

//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
    /**
     * clob
     * 지정할 수 있는 속성이없다
     */
    @Lob
    private String description;
    //    컬럼 제외 메모리에서만 사용
    @Transient
    private int temp;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public LocalDate getTestLocalDate() {
        return testLocalDate;
    }

    public void setTestLocalDate(LocalDate testLocalDate) {
        this.testLocalDate = testLocalDate;
    }

    public LocalDateTime getTestLocalDateTime() {
        return testLocalDateTime;
    }

    public void setTestLocalDateTime(LocalDateTime testLocalDateTime) {
        this.testLocalDateTime = testLocalDateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}