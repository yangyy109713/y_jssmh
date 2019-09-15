package com.yyy.demo.base;

import java.math.BigDecimal;

public class TestBigDecimal {

    public static void main(String[] args) {
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal orders = new BigDecimal(870133.0000);
        BigDecimal orderM = new BigDecimal(5866121.9900);
        System.out.println(orderM.divide(orders, 20, BigDecimal.ROUND_HALF_UP).doubleValue());
    }
}
