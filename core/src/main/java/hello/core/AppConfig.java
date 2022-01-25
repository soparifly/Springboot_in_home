package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @Configuration 설정 정보
 */
@Configuration
public class AppConfig {
    /**
     * 기획 AppConfig
     * 구체 클래스를 선택하고 담당하는 전체구성을 책임진다
     * 각 서비스는 기능을 실행하는 책임만 지면된다
     * @return
     */

    /**
     * memberService->new  MemoryRe~
     * OrderService -> new MemoryRe~
     * 결과적으로 각각 다른 메모리 리파짓토리가 생성되면서 싱글톤이 깨지는 것 처럼 보인다
     * Test-> ConfigurationSingletonTest
     * <p>
     * Sprin이  SingTon을 보장하는방법
       * 싱글톤 레지스트리다
     * 싱글톤이되도록 보장을 해줘야한다
     * 코드자체를 처리할순없다
     *
     * @Configuration CGLIB이라는 바이트 코드 조작 라이브러리를 사용해서 AppConfig클래스를 상속받은 임의의 다른 클래스를 만들고
     * 실제 다른 클래스를 스프링 빈으로 등록한것
     * instance : AppConfig@CGLIB (AppConfig 의 자식타입)
     * 임의의 다른 클래스가 바로 싱글톤 보장되도록
     * <p>
     * if->
     * memberRepository -> bean 에 있을 경우 스프링 컨테이너에서 찾아서 반환
     * -> else
     * 없으면 기존 로직을 호출해서 인스턴스를 생성하고 스프링 컨테이너에 등록한다
     * return 을 반환한다
     * <p>
     * 싱글 톤 보장
     * @Bean이 붙은 메서드마다 스프링 빈이 존재하면 존재하는 빈을 반환하고 없으면 생성해서 스프링 빈으로 등록하고 반환하는 코드가 동적으로 만들어진다
     *
     *
     *
     *
     *
     * @Configuration 이 없으면 CGLIB기술을 사용하지않는다
     * @Bean이붙은 메서드를 컨테이너에 빈이 존재하든말든 새로운 인스턴스를 계속 반환하는 동작을 해버림
     *
     *
     */

    /*
    Bean 으로 등록하면 spring 컨테이너에 등록된다
     */
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");

        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {

        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();

    }


}
