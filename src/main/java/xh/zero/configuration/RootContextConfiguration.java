package xh.zero.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(
        basePackages = "xh.zero.site",
        excludeFilters = @ComponentScan.Filter(Controller.class)
)
public class RootContextConfiguration {
}
