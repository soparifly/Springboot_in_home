package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
/**
 * basepackage 를 지정해서 원하는 컴포넌트만 스캔할수있음
 * 객체형식으로 여러개 지정도가능
 * 지정하지않으면
 */
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
