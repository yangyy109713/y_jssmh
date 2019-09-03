package configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"dao", "service", "controller"}) //包扫描
public class MainConfigAutowired {

}
