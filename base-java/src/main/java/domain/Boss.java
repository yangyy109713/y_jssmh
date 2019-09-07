package domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//默认加在容器中的组件，容器启动会默认调用无参构造器，在调用初始化赋值等操作
@Component
public class Boss {
    private Car car;

    //标注在构造器位置，表示构造器要用的参数，都是从容器中获取
    //@Autowired
    public Boss(@Autowired Car car) {
        this.car = car;
        System.out.println("Boss。。。有参构造器...");
    }

    public Car getCar() {
        return car;
    }

    //@Autowired
    //注解标注在方法上，Spring容器创建当前对象，就会调用方法，完成赋值
    //方法使用的参数：自定义类型的值，从IOC容器中获取
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
