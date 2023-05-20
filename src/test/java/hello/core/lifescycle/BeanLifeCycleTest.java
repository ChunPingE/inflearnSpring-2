package hello.core.lifescycle;

import org.junit.jupiter.api.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;

class BeanLifeCycleTest {
	@Test
	public void lifeCycleTest() {
		ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
		NextWorkClinet client = ac.getBean(NextWorkClinet.class);
		ac.close(); // 스프링 컨테이너를 종료, ConfigurableApplicationContext 필요
	}

	@Configuration
	static class LifeCycleConfig {
		
		//@Bean(initMethod = "init", destroyMethod = "close")
		@Bean
		public NextWorkClinet networkClient() {
			NextWorkClinet networkClient = new NextWorkClinet();
			networkClient.setUrl("http://hello-spring.dev");
			return networkClient;
		}
	}
}
