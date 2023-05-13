package hello.core;

import org.springframework.context.*;
import org.springframework.context.annotation.*;

import hello.core.member.*;
import hello.core.order.*;

public class OrderApp {
	public static void main(String[] args) {
		//AppConfig appConfig = new AppConfig();
		//MemberService memberService = appConfig.memberService();
		//OrderService orderService = appConfig.orderService();
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = (MemberService) applicationContext.getBean("memberSerivce");
		OrderService orderService = (OrderService) applicationContext.getBean("orderService");
		
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);

		Order order = orderService.createOrder(memberId, "itemA", 10000);
		System.out.println(order.toString());
	}
}
