package hello.core.singleton;

public class StateFullService {
    //    무상태변경(stateless)설계
    /**
     * 싱글톤 패턴이든 스프링 같은 싱글톤 컨테이너를 사용하든, 객체 인스턴스를 하나만 생성해서 공유하는 싱글톤 방식은
     * 여러클라이언트가 하나의 같은 객체 인스턴스를 공유하기때문에 싱글톤 객체는 상태를 유지(stateful)하게 설계하면 안된다
     *
     * 특정 클라이언트에 의존적인 필드가 있으면안된다.
     * 틀정 클라이언트가 값을 변경 할 수 있는 필드가 있으면 안된다,
     * 가급적 읽기만 가능해야한다
     * 필드 대신에 자바에서 공유되지않는, 지역변수, 파라미터, ThreadLocal 등을 사용해야한다
     *
     * 스프링 빈의 필드에 공유값을 설정하면 정말 큰장애가 발생할 수 있다
     *
     */
    //공유 필드 주의
//    private int price;


    //상태를 유지하는 필드
    public int order(String name, int price) {
        System.out.println("name" + name + "price" + price);

//        this.price = price;// 여기문제
        return price;
    }
//
//    public int getPrice() {
//        return price;
//    }

}
