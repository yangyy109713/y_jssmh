package com.yyy.demo.base;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateFormatTest {


    @Test
    public void test(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now: " + now.toLocalTime().toString());
        Date insTmStart = Date.from(now.minusDays(1).atZone(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:SS:MM");
        System.out.println("insTmStart" +simpleDateFormat.format(insTmStart));
    }

}
