package hello.core;

import hello.core.discount.*;
import hello.core.member.*;
import hello.core.order.*;

public class AppConfig {

	private MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}

	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}
	
	public DiscountPolicy discountPolicy() {
		//return new FixDiscountPolicy();
		return new RateDiscountPolicy();
	}

	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
}
