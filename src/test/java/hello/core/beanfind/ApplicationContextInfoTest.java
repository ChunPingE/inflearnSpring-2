package hello.core.beanfind;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.config.*;
import org.springframework.context.annotation.*;

import hello.core.*;

public class ApplicationContextInfoTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	@DisplayName("모든 빈 출력하기")
	void findAllBean() {
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			Object bean = ac.getBean(beanDefinitionName); // 타입지정안했기때문에 Object
			System.out.println("name=" + beanDefinitionName + " object=" +
					bean);
		}
	}

	@Test
	@DisplayName("애플리케이션 빈 출력하기")
	void findApplicationBean() {
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
			// Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
			// Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
			if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
				Object bean = ac.getBean(beanDefinitionName);
				System.out.println("name=" + beanDefinitionName + " object=" +
						bean);
			}
		}
	}

}
