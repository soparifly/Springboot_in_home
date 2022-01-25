package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {


    private final MemberRepository memberRepository;

    /**
     * @Autowired
     *  생성자에 의존관계 주입
     *
     * @param memberRepository
     */
    //ac.getBean(MemberRepository.class)
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
