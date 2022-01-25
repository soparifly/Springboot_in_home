package hello.core.singleton;

public class SingleTonService {
/*
클라이언트 호출에 따라 계속 인스턴스가 생성되는것을 방지하기위해
싱글톤 디자인 패턴을 사용한다
static 영역에 객체 instance를 미리하나 생성한다

생성된 객체를 가져다가 사용함

 */
    private
    static final SingleTonService instance = new SingleTonService();

    public static SingleTonService getInstance() {
        return instance;
    }


    private SingleTonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
/**
 *싱글톤패턴의 문제점
 * 싱글톤 패턴을 구현하는 코드자체가 많이들어간다
 * 의존 관계상 클라이언트가 구체클래스에 의존한다
 * OCP 위반가능성이높다
 * 테스트하기 어렵다
 * 내부 속성을 변경하거나 초기화하기 어렵다
 * private 생성자로 자식클래스를 만들기어렵다
 * 결론적으로 유연성이 떨어진다
 * 안티패턴으로불리기도한다.
 *
 */