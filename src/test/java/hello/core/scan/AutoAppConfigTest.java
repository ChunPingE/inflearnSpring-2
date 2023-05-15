package hello.core.scan;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;

import hello.core.*;
import hello.core.member.*;

public class AutoAppConfigTest {
	@Test
	void basicScan() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
		MemberService memberService = ac.getBean(MemberService.class);
		assertThat(memberService).isInstanceOf(MemberService.class);
	}
}
