package com.yovvis.utils;

import cn.hutool.core.util.StrUtil;

/**
 * sql 工具类
 *
 * @author yovvis
 */
public class SqlUtils {
    public SqlUtils() {
    }

    /**
     * 校验排序字段是否合法（防止 SQL 注入）
     *
     * @param sortField
     * @return
     */
    public static boolean validSortField(String sortField) {
        if (StrUtil.isBlank(sortField)) {
            return false;
        }
        return !StrUtil.containsAny(sortField, "=", "(", ")", " ");
    }
}
