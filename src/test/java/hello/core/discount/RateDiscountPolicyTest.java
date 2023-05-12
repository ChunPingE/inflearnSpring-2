package hello.core.discount;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

import hello.core.member.*;

class RateDiscountPolicyTest {

	RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

	@Test
	@DisplayName("vip는 10% 할인이 적용되어야한다.")
	void vip_o() {
		// given
		Member member = new Member(1L, "memverVip", Grade.VIP);
		// when
		int discount = discountPolicy.discount(member, 10000);
		// then
		assertThat(discount).isEqualTo(1000);
	}

	@Test
	@DisplayName("vip가아니면 할인적용되지 않아야한다.")
	void vip_x() {
		// given
		Member member = new Member(1L, "memverBASIC", Grade.BASIC);
		// when
		int discount = discountPolicy.discount(member, 10000);
		// then
		assertThat(discount).isEqualTo(0);
	}
}
