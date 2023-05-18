package hello.core.discount;

import org.springframework.stereotype.*;

import hello.core.annotation.*;
import hello.core.member.*;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

	private int discountPercent = 10;

	@Override
	public int discount(Member member, int price) {
		if (member.getGrade() == Grade.VIP) {
			return price * discountPercent / 100;
		} else {
			return 0;
		}
	}
}
