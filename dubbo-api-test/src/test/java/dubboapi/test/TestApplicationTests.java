package dubboapi.test;

import dubboapi.test.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;//将容器自动装配

    //验证是否将beans.xml中定义的service导入成功
    @Test
    public void test4ImportResource(){
        boolean b = ioc.containsBean("userService");
        System.out.println(b);
    }

    @Test
    public void test(){
        System.out.println(person);
    }

}
