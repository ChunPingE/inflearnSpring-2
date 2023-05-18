package hello.core.autowired;

import java.util.*;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;
import org.springframework.lang.*;

import hello.core.member.*;

public class AutowiredTest {

	@Test
	void AutowiredOption() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
	}

	static class TestBean {
		// 호출안됨
		@Autowired(required = false)
		public void setNoBean1(Member member) {
			System.out.println("setNoBean1 = " + member);
		}

		// null 호출
		@Autowired
		public void setNoBean2(@Nullable Member member) {
			System.out.println("setNoBean2 = " + member);
		}

		// Optional.empty 호출
		@Autowired(required = false)
		public void setNoBean3(Optional<Member> member) {
			System.out.println("setNoBean3 = " + member);
		}
	}
}
