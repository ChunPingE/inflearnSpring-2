package hello.core;

import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.*;

@Configuration
@ComponentScan(
		basePackages = "hello.core",
		excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {

}
