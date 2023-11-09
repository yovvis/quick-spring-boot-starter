package com.yovvis.utils;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

public class CollectionUtils {

    public static <T> boolean isEmpty(T[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(Iterator<?> Iterator) {
        return null == Iterator || !Iterator.hasNext();
    }

    public static boolean isEmpty(Iterable<?> iterable) {
        return null == iterable || isEmpty(iterable.iterator());
    }

    public static boolean isEmpty(Enumeration<?> enumeration) {
        return null == enumeration || !enumeration.hasMoreElements();
    }

    public static boolean isNotEmpty(Enumeration<?> enumeration) {
        return !isEmpty(enumeration);
    }

    public static boolean isNotEmpty(Iterator<?> Iterator) {
        return !isEmpty(Iterator);
    }

    public static boolean isNotEmpty(Iterable<?> iterable) {
        return !isEmpty(iterable);
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static <T> boolean isNotEmpty(T[] array) {
        return !isEmpty(array);
    }
}
