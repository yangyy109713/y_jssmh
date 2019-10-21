package dubboapi.test.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将配置文件中的属性，映射到组件中
 * @ConfigurationProperties：
 *    告诉SpringBoot将本类中的所有属性和配置文件中相关的配置绑定
 *    默认从全局配置文件applcation.propertis/.yml中获取值
 * prefix = "person" 指定使用配置文件中哪个配置信息
 *
 * 只有将组件加入容器中时，才能使用容器提供的@ConfigurationProperties
 *
 * @PropertySource
 *    加载指定的配置文件
 */
@PropertySource(value={"classpath:person.properties"})
@Component
@ConfigurationProperties(prefix = "person")
public class Person {

    //@Value("${person.lastName}")
    private String lastName;

    //@Value("#{11*2+2}")
    private Integer age;

    //@Value("${person.boss}")
    private Boolean boss;

    private Date birth;

    private Map<String, Object> map;

    private List<Object> list;

    private User user;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", map=" + map +
                ", list=" + list +
                ", user=" + user +
                '}';
    }
}
