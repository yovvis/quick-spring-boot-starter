package com.yovvis.utils;

import java.util.Map;

/**
 * Map工具类
 *
 * @author yovvis
 */
public class MapUtils {
    public MapUtils() {
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return null == map || map.isEmpty();
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }
}
