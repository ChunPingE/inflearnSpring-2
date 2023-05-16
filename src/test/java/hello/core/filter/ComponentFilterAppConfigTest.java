package hello.core.filter;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.*;

public class ComponentFilterAppConfigTest {

	@Test
	void filterScan() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppconfig.class);

		BeanA beanA = ac.getBean("beanA", BeanA.class);
		assertThat(beanA).isNotNull();
		
		Assertions.assertThrows(
				NoSuchBeanDefinitionException.class,
				() -> ac.getBean("beanB", BeanB.class));
	}

	@Configuration
	@ComponentScan(includeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class), excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class))
	static class ComponentFilterAppconfig {

	}
}