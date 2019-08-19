package com.yangyy.hadoop.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateFormat {
    /**
     * 格式化时间
     * @param time
     * @return 输出格式为"yyyy/MM/dd ahh:mm:ss"
     */
    public static String getModificationTimeFormat(long time){
        Date date = new Date(time);
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd ahh:mm:ss");
        return localDateTime.format(dateTimeFormatter);
    }
}
