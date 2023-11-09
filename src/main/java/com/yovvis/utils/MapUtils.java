package com.yovvis.utils;

import java.util.Map;

public class MapUtils {
    public static boolean isEmpty(Map<?, ?> map) {
        return null == map || map.isEmpty();
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }
}
