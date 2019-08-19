package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期类型比较大小
 * @author yuanyuanyang
 */
public class DateTest1 {

    public static void main(String[] args){
        String pattern = "yyyy-MM-dd HH:mm:ss";
        System.out.println(dateToString(new Date(), pattern));

        String str = "2019-07-25 09:30:59";
        System.out.println(strToDate(str, pattern));//打印的Date是格林威治时间

        String str1 = "2019-07-01 09:30:59";
        String str2 = "2019-07-01 09:45:59";
        System.out.println();
        System.out.println("====使用Date类的compareTo()比较日期大小====");
        compareDate(str, str, pattern);
        compareDate(str1, str2, pattern);
        compareDate(str2, str1, pattern);

        System.out.println();
        System.out.println("====使用Date类的before、after、equals比较日期大小====");
        compareDate1(str, str, pattern);
        compareDate1(str1, str2, pattern);
        compareDate1(str2, str1, pattern);

        System.out.println();
        System.out.println("====通过Date的getTime()方法获取到毫秒数，比较日期大小====");
        compareDate2(str, str, pattern);
        compareDate2(str1, str2, pattern);
        compareDate2(str2, str1, pattern);
    }

    /**
     * 通过Date的getTime()方法获取到毫秒数，比较日期大小
     * @param str1 String类型日期1
     * @param str2 String类型日期2
     * @param pattern 日期格式
     */
    public static void compareDate2(String str1, String str2, String pattern){
        long l1 = strToDate(str1, pattern).getTime();
        long l2 = strToDate(str1, pattern).getTime();
        if (l1 < l2) System.out.println(str1+ " 小于 "+ str2);
        if (l1 > l2) System.out.println(str1+ " 大于 "+ str2);
        if (l1 == l2) System.out.println(str1+ " 等于 "+ str2);
    }

    /**
     * 使用Date的before、after、equals方法比较日期大小
     * @param str1 String类型日期1
     * @param str2 String类型日期2
     * @param pattern 日期格式
     */
    public static void compareDate1(String str1, String str2, String pattern){
        boolean f1 = strToDate(str1, pattern).before(strToDate(str2, pattern));
        boolean f2 = strToDate(str1, pattern).after(strToDate(str2, pattern));
        boolean f3 = strToDate(str1, pattern).equals(strToDate(str2, pattern));
        if (f1) System.out.println(str1+ " 小于 "+ str2);
        if (f2) System.out.println(str1+ " 大于 "+ str2);
        if (f3) System.out.println(str1+ " 等于 "+ str2);
    }

    /**
     * 使用Date的compareTo()比较日期大小
     * java.util.Date类实现了Comparable接口
     * @param str1 String类型日期1
     * @param str2 String类型日期2
     * @param pattern 日期格式
     */
    public static void compareDate(String str1, String str2, String pattern){
        int i = strToDate(str1, pattern).compareTo(strToDate(str2, pattern));
        if(i == 0) System.out.println(str1+ " 等于 "+ str2);
        if(i == 1) System.out.println(str1+ " 大于 "+ str2);
        if(i == -1) System.out.println(str1+ " 小于 "+ str2);
    }

    /**
     * 根据给定的日期格式，将Date转换成String
     * @param date 日期
     * @param pattern 给定的日期格式
     * @return String类型日期
     */
    public static String dateToString(Date date, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }


    /**
     * 根据给定日期格式，将String转换成Date
     * @param str String格式日期
     * @param pattern 给定的日期格式
     * @return Date类型日期
     */
    public static Date strToDate(String str, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(str);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }
}
