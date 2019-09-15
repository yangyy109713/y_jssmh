package prototype;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 用带原型管理器的原型模式来生成包含“圆”和“正方形”等图形的原型，并计算其面积.
 */
public class PrototypeShape {
    public static void main(String[] args) {
        PrototypeManager pm = new PrototypeManager();
        Shape obj1 = (Circle) pm.getShape("Circle");
        obj1.countArea();

        Shape obj2 = (Square) pm.getShape("Square");
        obj2.countArea();
    }
}

interface Shape extends Cloneable {
    Object clone();

    void countArea();
}

class Circle implements Shape {
    @Override
    public Object clone() {
        Circle circle = null;
        try {
            circle = (Circle) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("拷贝 圆 失败!");
        }
        return circle;
    }

    @Override
    public void countArea() {
        int r = 0;
        System.out.print("这是一个圆，请输入圆的半径：");
        Scanner scanner = new Scanner(System.in);
        r = scanner.nextInt();
        System.out.println("该圆的面积 = " + 3.1415 * r * r + "\n");
    }
}

class Square implements Shape {
    @Override
    public Object clone() {
        Square square = null;
        try {
            square = (Square) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("拷贝 正方形 失败!");
        }
        return square;
    }

    @Override
    public void countArea() {
        int a = 0;
        System.out.print("这是一个正方形，请输入它的边长：");
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        System.out.println("该正方形的面积 = " + a * a + "\n");
    }
}

class PrototypeManager {
    private HashMap<String, Shape> ht = new HashMap<>();

    //管理原型：已有"圆 正方形"原型
    public PrototypeManager() {
        ht.put("Circle", new Circle());
        ht.put("Square", new Square());
    }

    public void addShape(String key, Shape obj) {
        ht.put(key, obj);
    }

    public Shape getShape(String key) {
        Shape temp = ht.get(key);
        return (Shape) temp.clone();
    }
}