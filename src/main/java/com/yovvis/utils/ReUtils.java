package com.yovvis.utils;

import java.util.regex.Pattern;

/**
 * ReUtils
 *
 * @author yovvis
 * @date 2023/11/25
 */
public class ReUtils {
    public static boolean isMatch(Pattern pattern, CharSequence content) {
        return content != null && pattern != null ? pattern.matcher(content).matches() : false;
    }
}
