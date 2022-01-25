package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {
    @Test
    @DisplayName("스프리 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        //1. 조회: 호출할때마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();
//1. 조회: 호출할때마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();
        //참조값이 다른것을 확인
        System.out.println("memberService1 =   " + memberService1);
        System.out.println("memberService2 =   " + memberService2);

        //memberService1 = memberService2 다름확인
        assertThat(memberService1).isNotSameAs(memberService2);

    }

    /*
    singletonService1 = hello.core.singleton.SingleTonService@646be2c3
    singletonService2 = hello.core.singleton.SingleTonService@646be2c3
     */
    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void
    singletonServiceTest() {
        SingleTonService singleTonService1 = SingleTonService.getInstance();
        SingleTonService singleTonService2 = SingleTonService.getInstance();
        System.out.println("singletonService1 = " + singleTonService1);
        System.out.println("singletonService2 = " + singleTonService2);

        assertThat(singleTonService1).isSameAs(singleTonService2);
        //same == 참조비교

    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
//        AppConfig appConfig = new AppConfig();
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println("memberService1 =   " + memberService1);
        System.out.println("memberService2 =   " + memberService2);

        //memberService1 = memberService2 다름확인
        assertThat(memberService1).isSameAs(memberService2);


    }
}
