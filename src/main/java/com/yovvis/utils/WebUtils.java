package com.yovvis.utils;

/**
 * web工具类
 *
 * @author yovvis
 */
public class WebUtils {
    public WebUtils() {
    }

    // 字符串转成数字
    public static int parseInt(String numStr, int defaultVal) {
        try {
            return Integer.parseInt(numStr);
        } catch (Exception e) {
            System.out.println(numStr + "不能转成数字");
        }
        return defaultVal;
    }
}
