package date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 日期工具类
 * 在commons-lang-2.X.jar包或commons-lang3-3.X.jar包中
 * 本次测试使用commons-lang-2.6.jar包
 * DateUitls工具类提供了解析日期字符串成日期对象的方法，但没有提供格式化日期对象成日期字符串的方法
 * 解析字符串时可以用DateUtils工具类，格式化日期对象时就得自己写SimpleDateFormat类操作
 */
public class DateUtilsTest {

    public static void main(String[] args){
        String str1 = "2019-07-01 23:01:12";
        String str2 = "2019-07-31 23:01:12";
        String[] strings = {"yyyy-MM-dd HH:mm:ss"};
        System.out.println("是否同一天："+ isSameDay(str2Date(str1, strings), str2Date(str2, strings)));
        System.out.println("是否相同毫秒数："+ isSameMilliSecond(str2Date(str1, strings), str2Date(str2, strings)));
        System.out.println("获取年份字符串："+ getCurrentYear(str2Date(str1, strings)));
        System.out.println("获取月份字符串："+ getCurrnetMonthStr(str2Date(str1, strings)));
        System.out.println("获取日期字符串："+ getCurrentDayStr(str2Date(str1, strings)));
        System.out.println("获取时间字符串："+ getCurrentTimeStr(str2Date(str1, strings)));

        System.out.println();
        System.out.println("=======DateUtils加(减) 日期Api测试（传参-正数，表示加；负数，表示减）======= ");
        System.out.println(str2+ " 加1年 = "+ getFormatPattern(DateUtils.addYears(str2Date(str2, strings), 1)));
        System.out.println(str2+ " 加2月 = "+ getFormatPattern(DateUtils.addMonths(str2Date(str2, strings), 2)));
        System.out.println(str2+ " 加3周 = "+ getFormatPattern(DateUtils.addWeeks(str2Date(str2, strings), 3)));
        System.out.println(str2+ " 加4天 = "+ getFormatPattern(DateUtils.addDays(str2Date(str2, strings), 4)));
        System.out.println(str2+ " 加5小时 = "+ getFormatPattern(DateUtils.addHours(str2Date(str2, strings), 5)));
        System.out.println(str2+ " 加6分钟 = "+ getFormatPattern(DateUtils.addMinutes(str2Date(str2, strings), 6)));
        System.out.println(str2+ " 加7秒 = "+ getFormatPattern(DateUtils.addSeconds(str2Date(str2, strings), 7)));
        System.out.println(str2+ " 加1000毫秒 = "+ getFormatPattern(DateUtils.addMilliseconds(str2Date(str2, strings), 1000)));

        System.out.println();
        System.out.println("=======DateUtils.truncate 日期Api测试======= ");
        System.out.println(str2+ " 把天后的数据清掉，结果："+ getFormatPattern(DateUtils.truncate(str2Date(str2, strings), Calendar.DAY_OF_MONTH)));
        System.out.println(str2+ " 把小时后的数据清掉，结果："+ getFormatPattern(DateUtils.truncate(str2Date(str2, strings), Calendar.HOUR_OF_DAY)));
        System.out.println(str2+ " 把小时后的数据清掉，结果："+ getFormatPattern(DateUtils.truncate(str2Date(str2, strings), Calendar.HOUR_OF_DAY)));

        System.out.println();
        System.out.println("今年已经过去了多少天："+ DateUtils.getFragmentInDays(new Date(), Calendar.YEAR));
        System.out.println("当月已经过去了多少天："+ DateUtils.getFragmentInDays(new Date(), Calendar.MONTH));
        System.out.println("当天已经过去了多少小时："+ DateUtils.getFragmentInHours(new Date(), Calendar.DATE));
        System.out.println("当前小时已经过去了多少分钟："+ DateUtils.getFragmentInMinutes(new Date(), Calendar.HOUR_OF_DAY));
        System.out.println("当前分钟已经过去了多少秒："+ DateUtils.getFragmentInSeconds(new Date(), Calendar.MINUTE));
        System.out.println("当前分钟已经过去了多少毫秒："+ DateUtils.getFragmentInMilliseconds(new Date(), Calendar.MINUTE));
        System.out.println("当前秒已经过去了多少毫秒："+ DateUtils.getFragmentInMilliseconds(new Date(), Calendar.SECOND));
    }


    //获取年份字符串
    public static String getCurrentYear(Date date){
        return getFormatPattern(date, "yyyy");
    }

    //获取月份字符串
    public static String getCurrnetMonthStr(Date date){
        return getFormatPattern(date, "MM");
    }

    //获取日期字符串
    public static String getCurrentDayStr(Date date){
        return getFormatPattern(date, "dd");
    }

    //获取时间字符串
    public static String getCurrentTimeStr(Date date){
        return getFormatPattern(date, "HH:mm:ss");
    }

    /**
     * 根据日期格式要求，获取字符串类型日期
     * 若格式为空，则使用默认格式yyyy-MM-dd HH:mm:ss
     * @param date 日期
     * @param patterns 要求的格式
     * @return 字符串
     */
    public static String getFormatPattern(Date date, Object... patterns){
        if(date == null){
            return null;
        }
        if(patterns != null && patterns.length > 0){
            return DateFormatUtils.format(date, patterns[0].toString());
        }else
            return DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 判断两个日期是否同一天
     * @return true/false
     */
    public static boolean isSameDay(Date date1, Date date2){
        return DateUtils.isSameDay(date1, date2);
    }

    /**
     * 判断两个日期时间是否同一毫秒
     * @return true/false
     */
    public static boolean isSameMilliSecond(Date date1, Date date2){
        return DateUtils.isSameInstant(date1, date2);
    }

    /**
     * 字符串转Date类型
     * @param str 字符串
     * @param pattern 格式
     * @return 日期对象
     */
    public static Date str2Date(String str, String... pattern){
        try {
            return DateUtils.parseDate(str, pattern);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Date转字符串
     * @param date 日期
     * @param pattern 格式
     * @return 字符串
     */
    public static String Date2Str(Date date, String pattern){
        return DateFormatUtils.format(date, pattern);
    }
}
