package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
    /**
     * 역할과 구현을 충실하게 분리했다
     * 다형성도 활용하고 인터페이스와 구현객체를 분리했다
     * <p>
     * 하지만 OCP, DIP 같은 객체 지향 설계원칙을 충실히 준수한걸로 보이지만 실제로 그렇지않다
     * 클래스 의존관계를 분석했을때
     * 추상인터페이스에 구체(구현)클래스는 fixdis~, radiscout~
     * 실제로 orderServiceImpl 은 추상인터페이스와 discount 구현 클래스 정책에도 의존하고있다.
     * 인터페이스에만 의존해야한다
     * <p>
     * <p>
     * DIP에 위반,
     * IMPL의 정책을 변경하는 순간 OrderSerivceImpl 소스코드도 변경해야한다
     * <p>
     * <p>
     * <p>
     * OCP는 확장은 하되변경은 하지말아야한다
     * 의존하도록 의존관계를 변경해야한다
     */

    /**
     * 인터페이스에만 의존함
     */
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository,@MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

//DIP 위반
    //    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //test
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
