package configs;

import domain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//使用@PropertySource 读取外部配置文件中的k/v，保存到运行环境变量中；可以多次重复使用，家在不同的配置文件到环境变量中
@PropertySource(value = "classpath:/application.properties")
@Configuration
public class MainConfigOfProperties {

    @Bean
    public Person person(){
        return new Person();
    }
}
