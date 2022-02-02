package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        //close는 ConfigurableApplicationContext 하위 메서드
        //AnnotationConfigApplicationContext 상위 인터페이스
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig{
        /**
         * 생성자 호출, url = null
         * connect : null
         *  call : null message : 초기화 연결 메시지
         * @return
         * 라이프사이클 (싱글톤)
         * 컨테이너 생성-> 빈생성 -> 의존관계 주입 -> 초기화 콜백 ->사용 -> 소멸전 콜백 -> 스프링 종료
         *
         *
         * 초기화 콜백 : 빈이 생성되고 빈의 의존관계 주입이 완료된후 호출
         * 소멸전 콜백 : 빈이 소멸되기 직전에 호출
         *
         * 객체를 생성과 초기화를 분리하자
         * 생성자안에서 무거운 작업을 하기보단
         * 생성과 초기화하는 부분을 명확하게 나누는 것이 중요
         * 
         */
        @Bean
//                (initMethod = "init",destroyMethod = "close")
        public NetworkClient newtworkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
