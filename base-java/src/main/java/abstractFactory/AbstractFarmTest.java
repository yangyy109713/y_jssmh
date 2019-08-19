package abstractFactory;

import javax.swing.*;
import java.awt.*;
import java.net.URLDecoder;

public class AbstractFarmTest {
    public static void main(String[] args){
        try {
            Farm farm;
            Animal1 animal;
            Plant plant;
            farm = (Farm)ReadXml.getObject();
            animal = farm.newAnimal();//
            plant = farm.newPlant();
            animal.show();
            plant.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

//抽象产品：动物类
interface Animal1 {
    void show();
}

//具体产品：马
class Horse1 implements Animal1 {
    JScrollPane pane;
    JFrame jFrame = new JFrame("抽象工厂模式测试类");
    public Horse1(){
        Container container = jFrame.getContentPane();
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1, 1));
        jPanel.setBorder(BorderFactory.createTitledBorder("动物：马"));
        pane = new JScrollPane(jPanel);
        container.add(pane, BorderLayout.CENTER);
        String path = Class.class.getClass().getResource("/").getPath();
        try {
            path = URLDecoder.decode(path,"utf-8");//路径中有空格，需要特殊处理，否则编译后获取不到
        }catch (Exception e){
            e.printStackTrace();
        }
        JLabel jLabel = new JLabel(new ImageIcon(path +"abstractFactory/horse.jpg"));
        jPanel.add(jLabel);
        jFrame.pack();
        jFrame.setVisible(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口
    }
    public void show(){
        jFrame.setVisible(true);
    }
}

//具体产品：牛
class Cattle1 implements Animal1 {
    JScrollPane pane;
    JFrame jFrame = new JFrame("抽象工厂模式测试类");
    public Cattle1(){
        Container container = jFrame.getContentPane();
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1, 1));
        jPanel.setBorder(BorderFactory.createTitledBorder("动物：牛"));
        pane = new JScrollPane(jPanel);
        container.add(pane, BorderLayout.CENTER);
        String path = Class.class.getClass().getResource("/").getPath();
        try {
            path = URLDecoder.decode(path,"utf-8");//路径中有空格，需要特殊处理，否则编译后获取不到
        }catch (Exception e){
            e.printStackTrace();
        }
        JLabel jLabel = new JLabel(new ImageIcon(path +"abstractFactory/cattle.jpg"));
        jPanel.add(jLabel);
        jFrame.pack();
        jFrame.setVisible(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口
    }
    public void show(){
        jFrame.setVisible(true);
    }
}

//抽象工厂：植物类
interface Plant{
    void show();
}

//具体产品：水果类
class Fruit implements Plant{
    JScrollPane pane;
    JFrame jFrame = new JFrame("抽象工厂模式测试类");
    public Fruit(){
        Container container = jFrame.getContentPane();
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1, 1));
        jPanel.setBorder(BorderFactory.createTitledBorder("植物：水果"));
        pane = new JScrollPane(jPanel);
        container.add(pane, BorderLayout.CENTER);
        String path = Class.class.getClass().getResource("/").getPath();
        try {
            path = URLDecoder.decode(path,"utf-8");//路径中有空格，需要特殊处理，否则编译后获取不到
        }catch (Exception e){
            e.printStackTrace();
        }
        JLabel jLabel = new JLabel(new ImageIcon(path +"abstractFactory/fruit.jpg"));
        jPanel.add(jLabel);
        jFrame.pack();
        jFrame.setVisible(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口
    }
    public void show(){
        jFrame.setVisible(true);
    }
}

//具体产品：鲜花类
class Flower implements Plant{
    JScrollPane pane;
    JFrame jFrame = new JFrame("抽象工厂模式测试类");
    public Flower(){
        Container container = jFrame.getContentPane();
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1, 1));
        jPanel.setBorder(BorderFactory.createTitledBorder("植物：鲜花"));
        pane = new JScrollPane(jPanel);
        container.add(pane, BorderLayout.CENTER);
        String path = Class.class.getClass().getResource("/").getPath();
        try {
            path = URLDecoder.decode(path,"utf-8");//路径中有空格，需要特殊处理，否则编译后获取不到
        }catch (Exception e){
            e.printStackTrace();
        }
        JLabel jLabel = new JLabel(new ImageIcon(path +"abstractFactory/flower.jpg"));
        jPanel.add(jLabel);
        jFrame.pack();
        jFrame.setVisible(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口
    }
    public void show(){
        jFrame.setVisible(true);
    }
}


//抽象工厂：农场
interface Farm {
    Animal1 newAnimal();
    Plant newPlant();
}

//具体工厂：Yyy农场
class YyyFarm implements Farm {
    public Animal1 newAnimal(){
        System.out.println("马出生了。。。");
        return new Horse1();
    }
    public Plant newPlant(){
        System.out.println("花开了。。。");
        return new Flower();
    }
}

//具体工厂：Sxf场
class SxfFarm implements Farm {
    public Animal1 newAnimal(){
        System.out.println("牛出生了。。。");
        return new Cattle1();
    }

    public Plant newPlant() {
        System.out.println("果子熟了。。。");
        return new Fruit();
    }
}