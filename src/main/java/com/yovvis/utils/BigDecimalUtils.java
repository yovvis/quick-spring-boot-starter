package com.yovvis.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 计算工具类
 *
 * @author yovvis
 */
public class BigDecimalUtils {
    public BigDecimalUtils() {
    }

    /**
     * 默认2位小数
     */
    private static DecimalFormat df = new DecimalFormat("##.00");

    /**
     * Double 转 String
     * @param num
     * @return
     */
    public static String format(Double num) {
        if (num == null) {
            return "0.00";
        }
        return df.format(num);
    }

    /**
     * 加法
     *
     * @param num1
     * @param num2
     * @return
     */
    public static double add(Double num1, Double num2) {
        if (num1 == null) {
            num1 = 0d;
        }
        BigDecimal bignum1 = new BigDecimal(Double.toString(num1));
        if (num2 == null) {
            num2 = 0d;
        }
        BigDecimal bignum2 = new BigDecimal(Double.toString(num2));
        return bignum1.add(bignum2).doubleValue();
    }

    /**
     * 减法
     *
     * @param num1
     * @param num2
     * @return
     */
    public static double subtract(Double num1, Double num2) {
        if (num1 == null) {
            num1 = 0d;
        }
        BigDecimal bignum1 = new BigDecimal(Double.toString(num1));
        if (num2 == null) {
            num2 = 0d;
        }
        BigDecimal bignum2 = new BigDecimal(Double.toString(num2));
        return bignum1.subtract(bignum2).doubleValue();
    }

    /**
     * 乘法
     *
     * @param num1
     * @param num2
     * @return
     */
    public static double multiply(Double num1, Double num2) {
        if (num1 == null) {
            num1 = 0d;
        }
        BigDecimal bignum1 = new BigDecimal(Double.toString(num1));
        if (num2 == null) {
            num2 = 0d;
        }
        BigDecimal bignum2 = new BigDecimal(Double.toString(num2));
        return bignum1.multiply(bignum2).doubleValue();
    }

    /**
     * 除法
     *
     * @param num1
     * @param num2
     * @return
     */
    public static double divide(Double num1, Double num2) {
        if (num1 == null) {
            num1 = 0d;
        }
        BigDecimal bignum1 = new BigDecimal(Double.toString(num1));
        if (num2 == null || num2 == 0d) {
            num2 = 1d;
        }
        BigDecimal bignum2 = new BigDecimal(Double.toString(num2));
        return bignum1.divide(bignum2, 3, BigDecimal.ROUND_HALF_UP).doubleValue();// 四舍五入 保留3位小数
    }

    /**
     * 除法
     *
     * @param num1
     * @param num2
     * @return
     */
    public static double divide(Double num1, Integer num2) {
        if (num1 == null) {
            num1 = 0d;
        }
        BigDecimal bignum1 = new BigDecimal(Double.toString(num1));
        if (num2 == null || num2 == 0) {
            num2 = 1;
        }
        BigDecimal bignum2 = new BigDecimal(Integer.toString(num2));
        return bignum1.divide(bignum2, 3, BigDecimal.ROUND_HALF_UP).doubleValue();// 四舍五入 保留3位小数
    }

    /**
     * 除法
     *
     * @param num1
     * @param num2
     * @return
     */
    public static double divide(Integer num1, Integer num2, Integer num3) {
        if (num1 == null) {
            num1 = 0;
        }
        BigDecimal bignum1 = new BigDecimal(Double.toString(num1));
        if (num2 == null || num2 == 0) {
            num2 = 1;
        }
        BigDecimal bignum2 = new BigDecimal(Integer.toString(num2));
        // 四舍五入 保留3位小数
        return bignum1.divide(bignum2, num3, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
