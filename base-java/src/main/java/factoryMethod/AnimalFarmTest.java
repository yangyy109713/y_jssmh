package factoryMethod;

import javax.swing.*;
import java.awt.*;
import java.net.URLDecoder;

public class AnimalFarmTest {
    public static void main(String[] args){
        try {
            Animal animal;
            AnimalFarm animalFarm;
            animalFarm = (AnimalFarm)ReadXml2.getObject();
            animal = animalFarm.newAnimal();
            animal.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

//抽象产品：动物类
interface Animal{
    public void show();
}

//具体产品：马
class Horse implements Animal{
    JScrollPane pane;
    JFrame jFrame = new JFrame("工厂方法测试类");
    public Horse(){
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
        JLabel jLabel = new JLabel(new ImageIcon(path +"factoryMethod/horse.jpg"));
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
class Cattle implements Animal{
    JScrollPane pane;
    JFrame jFrame = new JFrame("工厂方法测试类");
    public Cattle(){
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
        JLabel jLabel = new JLabel(new ImageIcon(path +"factoryMethod/cattle.jpg"));
        jPanel.add(jLabel);
        jFrame.pack();
        jFrame.setVisible(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口
    }
    public void show(){
        jFrame.setVisible(true);
    }
}

//抽象工厂：畜牧场
interface AnimalFarm{
   public Animal newAnimal();
}

//具体工厂：养马场
class HorseFarm implements AnimalFarm{
    public Animal newAnimal(){
        System.out.println("新马出生。。。");
        return new Horse();
    }
}

//具体工厂：养牛场
class CattleFarm implements AnimalFarm{
    public Animal newAnimal(){
        System.out.println("新马出生。。。");
        return new Cattle();
    }
}