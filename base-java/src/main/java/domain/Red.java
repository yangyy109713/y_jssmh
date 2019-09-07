package domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

//将Red加到IOC容器中
@Component
public class Red implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {

    private ApplicationContext applicationContext;

    @Override
    public void setBeanName(String name) {
        System.out.println("当前bean的名字:"+ name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("传入的ico:"+ applicationContext);//和测试类中使用的是同一个applicationContext
        this.applicationContext = applicationContext;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        //传入一个字符串解析器，如解析占位符（容器启动，创建red对象时，将stringValueResolver传入）
        String s = stringValueResolver.resolveStringValue("你好 ${os.name}，我是 #{80+15}");
        System.out.println("解析的字符串是："+ s);
    }
}
