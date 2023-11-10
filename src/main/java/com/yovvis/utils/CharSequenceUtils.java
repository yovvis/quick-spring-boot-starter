package com.yovvis.utils;

/**
 * @author yovvis
 */
public class CharSequenceUtils {

    static int indexOf(CharSequence cs, int searchChar, int start) {
        if (cs instanceof String) {
            return ((String)cs).indexOf(searchChar, start);
        } else {
            int sz = cs.length();
            if (start < 0) {
                start = 0;
            }

            if (searchChar < 65536) {
                for(int i = start; i < sz; ++i) {
                    if (cs.charAt(i) == searchChar) {
                        return i;
                    }
                }

                return -1;
            } else {
                if (searchChar <= 1114111) {
                    char[] chars = Character.toChars(searchChar);

                    for(int i = start; i < sz - 1; ++i) {
                        char high = cs.charAt(i);
                        char low = cs.charAt(i + 1);
                        if (high == chars[0] && low == chars[1]) {
                            return i;
                        }
                    }
                }

                return -1;
            }
        }
    }

    static int indexOf(CharSequence cs, CharSequence searchChar, int start) {
        if (cs instanceof String) {
            return ((String)cs).indexOf(searchChar.toString(), start);
        } else if (cs instanceof StringBuilder) {
            return ((StringBuilder)cs).indexOf(searchChar.toString(), start);
        } else {
            return cs instanceof StringBuffer ? ((StringBuffer)cs).indexOf(searchChar.toString(), start) : cs.toString().indexOf(searchChar.toString(), start);
        }
    }

    public static char[] toCharArray(CharSequence source) {
        int len = StringUtils.length(source);
        if (len == 0) {
            return ArrayUtils.EMPTY_CHAR_ARRAY;
        } else if (source instanceof String) {
            return ((String) source).toCharArray();
        } else {
            char[] array = new char[len];

            for (int i = 0; i < len; ++i) {
                array[i] = source.charAt(i);
            }
            return array;
        }
    }

    static boolean regionMatches(CharSequence cs, boolean ignoreCase, int thisStart, CharSequence substring, int start, int length) {
        if (cs instanceof String && substring instanceof String) {
            return ((String)cs).regionMatches(ignoreCase, thisStart, (String)substring, start, length);
        } else {
            int index1 = thisStart;
            int index2 = start;
            int tmpLen = length;
            int srcLen = cs.length() - thisStart;
            int otherLen = substring.length() - start;
            if (thisStart >= 0 && start >= 0 && length >= 0) {
                if (srcLen >= length && otherLen >= length) {
                    while(tmpLen-- > 0) {
                        char c1 = cs.charAt(index1++);
                        char c2 = substring.charAt(index2++);
                        if (c1 != c2) {
                            if (!ignoreCase) {
                                return false;
                            }

                            char u1 = Character.toUpperCase(c1);
                            char u2 = Character.toUpperCase(c2);
                            if (u1 != u2 && Character.toLowerCase(u1) != Character.toLowerCase(u2)) {
                                return false;
                            }
                        }
                    }

                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

}
