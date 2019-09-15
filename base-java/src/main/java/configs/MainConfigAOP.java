package configs;

import aop.LogAspects;
import aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 学习视频：https://www.bilibili.com/video/av20967380/?p=27
 * AOP：底层实现逻辑--动态代理
 * 指在程序运行期间，动态的将某段代码切入到指定位置并运行的编程方式
 * 1.导入AOP模块:Spring AOP（spring-aspects）
 * 2.定义一个业务逻辑类MathCalculator.java
 * 3.需求：在方法执行前、执行后、执行出现异常时打印日志/结果
 * 4.定义日志切面类LogAspects.java，类里的方法需要动态感知div方法运行到哪一步，然后执行不同方法
 * 通知方法：
 * 前置通知 @Before：logStart 在目标方法div执行前 执行
 * 后置通知 @After：logEnd 在目标方法div执行结束后 执行。无论方法是正常结束，还是异常结束，都会调用
 * 返回通知 @AfterReturning：logReturn 在目标方法div正常返回后 执行
 * 异常通知 @AfterThrowing：logException 在目标方法div出现异常后 执行
 * 环绕通知 @Around：动态代理，手动推荐目标方法执行（joinPoint.proceed）
 * 5.给切面类的方法标注 何时何地执行，即通知注释
 * 6.将切面类和业务逻辑类（目标方法类）都注入容器中
 * 7.必须告诉容器Spring哪个是切面类（给切面类加一个注解@Aspect）
 * （重点）8.给配置类添加注解@EnableAspectJAutoProxy（开启基于注解的切面编程AOP模式）
 * 在Spring中有很多@EnableXXX，表示开启某种功能
 * <p>
 * <p>
 * 主要步骤：
 * 1）将业务逻辑类和切面类都加入到容器中，告诉Spring哪个是切面类（使用@Aspect注解标识）
 * 2）在切面类上每一个通知方法上标注通知注解，告诉Spring何时何地执行（注意 切入点表达式的写法，参考官方文档详细说明）
 * 3）开启基于注解的AOP模式（若是配置文件，则在配置文件中指定）
 */

/**
 * AOP原理：看给容器中注册了什么组件，这个组件什么时候工作，这个组件的工作内容是什么
 *  @EnableAspectJAutoProxy
 *  1.@EnableAspectJAutoProxy是什么？
 *   使用@Import({AspectJAutoProxyRegistrar.class})：给容器中导入AspectJAutoProxyRegistrar
 *   利用AspectJAutoProxyRegistrar 自定义给容器中注册bean：AnnotationAwareAspectJAutoProxyCreator（注解装配模式的Aspect切面）
 *    org.springframework.aop.config.internalAutoProxyCreator = AnnotationAwareAspectJAutoProxyCreator
 *    1）如果容器中containsBeanDefinition("org.springframework.aop.config.internalAutoProxyCreator")，直接获取
 *    2）如果没有，则创建一个RootBeanDefinition beanDefinition = new RootBeanDefinition(cls);
 *       将beanDefinition注册到容器中：registry.registerBeanDefinition("org.springframework.aop.config.internalAutoProxyCreator", beanDefinition);
 *  2.AnnotationAwareAspectJAutoProxyCreator：
 *
 *
 */

@EnableAspectJAutoProxy
@Configuration
public class MainConfigAOP {

    //6.将切面类和业务逻辑类（目标方法类）都注入容器中
    //切面类注入到容器中
    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }

    //业务类注入到容器中
    @Bean
    public MathCalculator mathCalculator() {
        return new MathCalculator();
    }
}
