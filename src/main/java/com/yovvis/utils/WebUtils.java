package com.yovvis.utils;

/**
 * @author yovvis
 * @Description [web工具类]
 * @date 2023/10/3 15:49
 */
public class WebUtils {
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
