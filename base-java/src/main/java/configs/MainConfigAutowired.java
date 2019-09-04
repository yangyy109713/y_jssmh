package configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动装配：Spring利用依赖注入（DI），完成对IOC容器中各个组件的依赖关系赋值
 *
 * @Autowired：自动注入
 * 1）默认按照类型去IOC容器中找对应的组件：annotationContext.getBean(BookDao.class);找到则赋值
 * 2）如果找到多个相同类型组件，则将属性名称（如bookDao）作为组件的id无容器中查找
 * 3）使用@Qualifier("bookDao")执行要装配的组件的id，不使用属性名称
 * 4）自动装配默认 属性一定要赋值，否则会报错，可以使用@Autowired(required=false)避免报错
 * 5）@Primary：让Spring进行自动装配的时候，默认使用首选的bean
 *      也可以继续使用@Qualifier指定需要装配的bean的名字
 */

@Configuration
@ComponentScan({"dao", "service", "controller"}) //指定包扫描路径
public class MainConfigAutowired {


}
