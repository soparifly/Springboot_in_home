package hellojpa;

/**
 * @Column
 * ORDINAL enum '순서'를 데이터 베이스에 저장
 * STRING enum '이름'을 데이터 베이스에 저장
 * Default : EnumType.ORDINAL
 * ORDINAL 을 사용하면 안됨 STRING 으로 써야함
 */
public enum RoleType {
    USER,ADMIN
}
