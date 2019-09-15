package designPrincinple;

/**
 * 设计模式-里氏替换原则 示例说明
 * 子类可以扩展父类的功能，但不能改变父类原有的功能。
 * 也就是说：子类继承父类时，除添加新的方法完成新增功能外，尽量不要重写父类的方法。
 */

public class LSPtest {
    public static void main(String[] args) {
        Bird bird1 = new Swallow();
        Bird bird2 = new BrownKiwi();
        bird1.setSpeed(120);
        bird2.setSpeed(120);
        System.out.println("如果飞行300公里：");
        try {
            System.out.println("燕子将飞行" + bird1.getFlyTime(300) + "小时");
            System.out.println("几维鸟将飞行" + bird2.getFlyTime(300) + "小时");
        } catch (Exception e) {
            System.out.println("出现异常。。。");
        }
    }
}

class Bird {
    double flySpeed;

    public void setSpeed(double speed) {
        flySpeed = speed;
    }

    public double getFlyTime(double distance) {
        return (distance / flySpeed);
    }
}

class Swallow extends Bird {

}

class BrownKiwi extends Bird {
    public void setSpeed(double speed) {
        flySpeed = 0;
    }
}