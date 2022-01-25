package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StateFullServiceTest {

    @Test
    void statefullSinggleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StateFullService stateService1 = ac.getBean(StateFullService.class);
        StateFullService stateService2 = ac.getBean(StateFullService.class);

//TreadA: A사용자 10000원주문
        int userA = stateService1.order("userA", 10000);
        //ThreadB :B사용자 20000원 주문
        int userB = stateService2.order("userB", 20000);

//price = 20000


        //ThradA: 사용자 A 주문금액 조회
        // int price = stateService1.getPrice();
        //필드를 공유하지않고 변수에 따로담으면 값이 공유되지않는다
        System.out.println("price = " + userA);
        System.out.println("price = " + userB);

//        Assertions.assertThat(stateService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {
        @Bean
        public StateFullService stateFullService() {
            return new StateFullService();
        }
    }
}