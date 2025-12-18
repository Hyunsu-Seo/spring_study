package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImple;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.jspecify.annotations.NonNull;

public class AppConfig {

    // 역할이 드러나지 않음 
    public MemberService memberService() {
        return new MemberServiceImple(memberRepository()); // 생성자 주입
    }
    // 역할이 드러남
    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    // 역할이 드러나지 않음
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    // 역할이 드러남
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
// 중복이 제거가 되어 MemoryMemberRepository를 다른 구현체로 변경할 때 한 부분만 변경하면 됨
// 애플리케이션 전체 구성이 어떻게 되어 있는지 빠르게 파악 가능