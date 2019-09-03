package configs;

import beans.Car;
import beans.Cat;
import beans.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 *  * Bean的生命周期
 *  * bean创建---初始化---销毁的过程
 *  * 容器管理bean的生命周期：
 *  * 自定义初始化和销毁方法，容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
 *  *
 *  * 构造（创建对象）
 *  * 单实例：容器启动时创建；多实例：每次调用时创建
 *  * -初始化：对象创建完成，并赋值好时调用
 *  * -销毁：容器关闭时调用（多实例：容器不会管理这个Bean，即容器关闭时不会调用销毁方法）
 *  * 1.通过@Bean注解指定初始化和销毁方法：@Bean(initMethod = "init", destroyMethod = "destroy")
 *
 *  * 2.通过让Bean实现InitializingBean（定义初始化逻辑）和DisposableBean（定义销毁逻辑）实现
 *
 *  * 3.使用JSR250（java规范）：
 *  * @PostContruct 在Bean创建，并赋值完成后，执行
 *  * @PreDestroy 在容器销毁之前
 *
 *  * 4.使用Bean的后置处理器BeanPostProcessor：Bean的后置处理器
 *  * 在Bean初始化前后进行处理
 *  * postProcessBeforeInitialization：在初始化之前调用
 *  * postProcessAfterInitialization：在初始化之后调用
 */

@Configuration
public class MainConfigOfLifeCycle {
    //@Scope(value = "prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car(){
        Car car = new Car();
        return car;
    }

    //实现InitializingBean 和 DisposableBean
    @Bean
    public Cat cat(){
        return new Cat();
    }

    //使用JSR250
    @Bean
    public Dog dog(){
        return new Dog();
    }

    //使用Bean的后置处理器BeanPostProcessor
    @Bean
    public MyBeanPostProcessor myBeanPostProcessor(){
        return new MyBeanPostProcessor();
    }
}
