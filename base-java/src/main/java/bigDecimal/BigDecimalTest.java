package bigDecimal;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class BigDecimalTest {
    public static void main(String[] args)throws Exception{

        System.out.println("===BigDecimal类型对象值为0的定义===");
        System.out.println("值为0方式1："+ new BigDecimal(0));
        System.out.println("值为0方式2："+ BigDecimal.ZERO);

        BigDecimal b1 = new BigDecimal(1);
        BigDecimal b2 = new BigDecimal(0.2343);
        BigDecimal b3 = new BigDecimal(System.currentTimeMillis());
        BigDecimal b4 = new BigDecimal("123456.78912356");

        System.out.println("===BigDecimal类型对象加、减、乘、除===");
        System.out.println("加"+ b1.add(b2));
        System.out.println("减"+ b1.subtract(b2));
        System.out.println("乘"+ b1.multiply(b2));
        //Non-terminating decimal expansion 结果为无限小数，需要处理
        //BigDecimal bigDecimal = b3.divide(b4).setScale(4, BigDecimal.ROUND_HALF_DOWN);
        BigDecimal bigDecimal = b3.divide(b4, 5, BigDecimal.ROUND_HALF_DOWN);
        System.out.println("除"+ bigDecimal);

        System.out.println("===BigDecimal类型对象比较大小===");
        System.out.println((b1.compareTo(b2) > 0) ? b1+ "大于"+ b2 : b1+ "小于"+ b2);
        System.out.println((b2.compareTo(b1) > 0) ? b2+ "大于"+ b1 : b2+ "小于"+ b1);
        System.out.println((b1.compareTo(b1) == 0) ? b2+ "等于"+ b2 : "不相等");

        System.out.println("===BigDecimal类型对象，获取不同数值类型值===");
        System.out.println("doubleValue="+ b4.doubleValue());
        System.out.println("floatValue="+ b4.floatValue());
        System.out.println("longValue="+ b4.longValue());
        System.out.println("intValue="+ b4.intValue());

        System.out.println("===BigDecimal类型对象值，保留2位小数===");
        System.out.println("方法1："+ formatB1(b4));
        System.out.println("方法1："+ formatB2(b4));
        System.out.println("方法1："+ formatB3(b4));

        System.out.println("===BigDecimal类型对象值，四舍五入===");
        BigDecimal b5 = new BigDecimal(1879.876453);
        System.out.println(b5+ "四舍五入保留2位小数"+ b5.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        NumberFormat currency = NumberFormat.getCurrencyInstance();//货币格式化引用
        NumberFormat percent = NumberFormat.getPercentInstance();//百分比格式化引用
        percent.setMaximumFractionDigits(3);//小数点后最多3位

        System.out.println("贷款金额："+ currency.format(b5));
        System.out.println("利率："+ currency.format(b2));
        System.out.println("利息："+ currency.format(b5.multiply(b2)));
    }

    //保留两位小数
    public static String formatB1(BigDecimal bd){
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(bd);
    }
    public static String formatB2(BigDecimal bd){
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(bd);
    }
    public static String formatB3(BigDecimal bd){
        return String.format("%.2f", bd);
    }

}
