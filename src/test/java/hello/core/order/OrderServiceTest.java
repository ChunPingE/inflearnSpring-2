package hello.core.order;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

import hello.core.*;
import hello.core.member.*;

class OrderServiceTest {

	MemberService memberService;
	OrderService orderService;

	@BeforeEach
	public void beforeEach() {
		AppConfig appConfig = new AppConfig();
		memberService = appConfig.memberService();
		orderService = appConfig.orderService();
	}

	@Test
	void createOrder() {
		long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);
		Order order = orderService.createOrder(memberId, "itemA", 20000);
		assertThat(order.getDiscountPrice()).isEqualTo(2000);
	}
}
