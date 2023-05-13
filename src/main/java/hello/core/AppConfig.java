package hello.core;

import org.springframework.context.annotation.*;

import hello.core.discount.*;
import hello.core.member.*;
import hello.core.order.*;

@Configuration
public class AppConfig {

	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}

	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}
	
	@Bean
	public DiscountPolicy discountPolicy() {
		//return new FixDiscountPolicy();
		return new RateDiscountPolicy();
	}

	@Bean
	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
}
