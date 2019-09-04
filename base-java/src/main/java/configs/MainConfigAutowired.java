package configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动装配：Spring利用依赖注入（DI），完成对IOC容器中各个组件的依赖关系赋值
 *
 * @Autowired：自动注入
 * Spring定义的，推荐使用
 * 1）默认按照类型去IOC容器中找对应的组件：annotationContext.getBean(BookDao.class);找到则赋值
 * 2）如果找到多个相同类型组件，则将属性名称（如bookDao）作为组件的id无容器中查找
 * 3）使用@Qualifier("bookDao")执行要装配的组件的id，不使用属性名称
 * 4）自动装配默认 属性一定要赋值，否则会报错，可以使用@Autowired(required=false)避免报错
 * 5）@Primary：让Spring进行自动装配的时候，默认使用首选的bean
 *      也可以继续使用@Qualifier指定需要装配的bean的名字
 *
 * Spring支持使用@Resource（JSR250）和@Inject（JSR330）【java规范注解，脱离Spring框架，仍然可用】
 * @Resource：
 *      和@Autowired一样，实现自动装配功能，默认是按照组件名称装配
 *      不支持@Primary和@Autowired(required=false)
 * @Inject:
 *      使用前，需要导入javax.inject依赖包
 *      和@Autowired一样，实现自动装配功能，默认是按照组件名称装配
 *      支持@Primary，但是不支持@Autowired(required=false)
 *
 * AutowiredAnnotationBeanPostProcessor：解析完成自动装配功能
 *
 * BookDao如果是接口，必须要有实现类，且将实现类注入到容器中
 * 具体见BookDaoImpl.java 和 BookService
 * 否则 Spring容器装配Bean时会报错：No qualifying bean of type
 * ==接口不能实例化，spring ioc 即把对象实例化的部分交给了Spring容器
 */

@Configuration
@ComponentScan({"dao", "service", "controller"}) //指定包扫描路径
public class MainConfigAutowired {

}
