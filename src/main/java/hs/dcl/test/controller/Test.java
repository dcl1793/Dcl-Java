package hs.dcl.test.controller;

import cn.hutool.core.date.DateUtil;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {

        BigDecimal thousand=new BigDecimal(1000);
        BigDecimal countMao = new BigDecimal(100);
        BigDecimal divide = countMao.divide(thousand, 3, BigDecimal.ROUND_HALF_UP);
        System.out.println(divide);


    }
}
