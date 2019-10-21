package dubboapi.test.config;

import dubboapi.test.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration
 *   表示当前类是一个配置类，用于代替Spring的.xml文件
 *
 * Spring 使用<bean></bean>标签添加组件
 * SpringBoot 使用@Bean添加组件
 */
@Configuration
public class MyConfig {

    //将方法的返回值添加到容器中，容器中将组件的默认id = 方法名
    //如果修改方法名，则使用到该组件的地方，也要修改
    @Bean
    public UserServiceImpl userService(){
        return new UserServiceImpl();
    }
}
