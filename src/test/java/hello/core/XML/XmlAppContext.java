package hello.core.xml;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.springframework.context.*;
import org.springframework.context.support.*;

import hello.core.member.*;

public class XmlAppContext {
	
	@Test
	void xmlAppContext() {
		ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

		MemberService memberService = ac.getBean("memberService",
				MemberService.class);
		assertThat(memberService).isInstanceOf(MemberService.class);
	}
}