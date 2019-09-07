package domain;

import org.springframework.beans.factory.annotation.Value;

public class Person {
    /**
     * 使用@Value注解给属性赋值
     * 参数类型：
     * 1.基本数值，如字符串，数字等
     * 2.可以写SpEL：#{}    即Spring表达式
     * 3.可以写${}：从配置文件中取值（即运行环境中的值）
     * */

    @Value("bjyx")
    private String name;

    @Value("#{20-2}")
    private int age;

    @Value("${address}")
    private String address;

    public Person() {
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        System.out.println("getName:"+ name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
