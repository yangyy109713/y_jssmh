package prototype;

import javax.swing.*;
import java.awt.*;

public class PrototypeSunWukong {
    public static void main(String[] args){
        JFrame jFrame = new JFrame("原型模式测试");
        jFrame.setLayout(new GridLayout(1, 2));
        Container contentPane = jFrame.getContentPane();

        SunWukong swk1 = new SunWukong();
        contentPane.add(swk1);
        SunWukong swk2 = (SunWukong)swk1.clone();
        contentPane.add(swk2);

        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class SunWukong extends JPanel implements Cloneable{
    private static final long serialVersionUID = 5543049531872119328L;
    public SunWukong(){
        JLabel l1 = new JLabel(new ImageIcon("Wukong.jpg"));
        this.add(l1);
    }
    public Object clone(){
        SunWukong swk = null;
        try{
            swk = (SunWukong)super.clone();
        }catch (CloneNotSupportedException e){
            System.out.println("拷贝悟空失败！");
        }
        return swk;
    }
}
