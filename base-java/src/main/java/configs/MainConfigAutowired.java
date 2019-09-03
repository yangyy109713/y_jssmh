package configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"dao", "service", "controller"}) //指定包扫描路径
public class MainConfigAutowired {

}
