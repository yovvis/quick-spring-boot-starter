package com.yovvis.utils;

import com.yovvis.function.ToBooleanBiFunction;

/**
 * <origin：lang3>
 *
 * @author yovvis
 */
public class StringUtils {
    public static boolean isBlank(CharSequence cs) {
        int strLen = length(cs);
        if (strLen == 0) {
            return true;
        } else {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }

    public static boolean isAnyBlank(CharSequence... strArray) {
        if (ArrayUtils.isEmpty(strArray)) {
            return true;
        } else {
            CharSequence[] c1 = strArray;
            int len = strArray.length;

            for (int i = 0; i < len; ++i) {
                CharSequence cs = c1[i];
                if (isNotBlank(cs)) {
                    return false;
                }
            }

            return true;
        }
    }

    public static boolean isAllBlank(CharSequence... css) {
        if (ArrayUtils.isEmpty(css)) {
            return true;
        } else {
            CharSequence[] var = css;
            int len = css.length;

            for (int i = 0; i < len; ++i) {
                CharSequence cs = var[i];
                if (isNotBlank(cs)) {
                    return false;
                }
            }

            return true;
        }
    }

    public static boolean contains(CharSequence seq, CharSequence searchSeq) {
        if (seq != null && searchSeq != null) {
            return CharSequenceUtils.indexOf(seq, searchSeq, 0) >= 0;
        } else {
            return false;
        }
    }

    public static boolean contains(CharSequence seq, int searchChar) {
        if (isEmpty(seq)) {
            return false;
        } else {
            return CharSequenceUtils.indexOf(seq, searchChar, 0) >= 0;
        }
    }

    public static boolean containsAny(CharSequence cs, char... searchChars) {
        if (!isEmpty(cs) && !ArrayUtils.isEmpty(searchChars)) {
            int csLength = cs.length();
            int searchLength = searchChars.length;
            int csLast = csLength - 1;
            int searchLast = searchLength - 1;

            for (int i = 0; i < csLength; ++i) {
                char ch = cs.charAt(i);

                for (int j = 0; j < searchLength; ++j) {
                    if (searchChars[j] == ch) {
                        if (!Character.isHighSurrogate(ch)) {
                            return true;
                        }

                        if (j == searchLast) {
                            return true;
                        }

                        if (i < csLast && searchChars[j + 1] == cs.charAt(i + 1)) {
                            return true;
                        }
                    }
                }
            }

            return false;
        } else {
            return false;
        }
    }

    public static boolean containsAny(CharSequence cs, CharSequence searchChars) {
        return searchChars == null ? false : containsAny(cs, CharSequenceUtils.toCharArray(searchChars));
    }

    public static boolean containsAny(CharSequence cs, CharSequence... searchCharSequences) {
        return containsAny(StringUtils::contains, cs, searchCharSequences);
    }

    private static boolean containsAny(ToBooleanBiFunction<CharSequence, CharSequence> test, CharSequence cs, CharSequence... searchCharSequences) {
        if (!isEmpty(cs) && !ArrayUtils.isEmpty(searchCharSequences)) {
            CharSequence[] csq = searchCharSequences;
            int len = searchCharSequences.length;

            for (int i = 0; i < len; ++i) {
                CharSequence searchCharSequence = csq[i];
                if (test.applyAsBoolean(cs, searchCharSequence)) {
                    return true;
                }
            }

            return false;
        } else {
            return false;
        }
    }

    public static boolean containsAnyIgnoreCase(CharSequence cs, CharSequence... searchCharSequences) {
        return containsAny(StringUtils::containsIgnoreCase, cs, searchCharSequences);
    }

    public static boolean containsIgnoreCase(CharSequence str, CharSequence searchStr) {
        if (str != null && searchStr != null) {
            int len = searchStr.length();
            int max = str.length() - len;

            for (int i = 0; i <= max; ++i) {
                if (CharSequenceUtils.regionMatches(str, true, i, searchStr, 0, len)) {
                    return true;
                }
            }

            return false;
        } else {
            return false;
        }
    }

    public static boolean containsNone(CharSequence cs, char... searchChars) {
        if (cs != null && searchChars != null) {
            int csLen = cs.length();
            int csLast = csLen - 1;
            int searchLen = searchChars.length;
            int searchLast = searchLen - 1;

            for (int i = 0; i < csLen; ++i) {
                char ch = cs.charAt(i);

                for (int j = 0; j < searchLen; ++j) {
                    if (searchChars[j] == ch) {
                        if (!Character.isHighSurrogate(ch)) {
                            return false;
                        }

                        if (j == searchLast) {
                            return false;
                        }

                        if (i < csLast && searchChars[j + 1] == cs.charAt(i + 1)) {
                            return false;
                        }
                    }
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public static boolean containsNone(CharSequence cs, String invalidChars) {
        return invalidChars == null ? true : containsNone(cs, invalidChars.toCharArray());
    }

    public static boolean containsOnly(CharSequence cs, String validChars) {
        return cs != null && validChars != null ? containsOnly(cs, validChars.toCharArray()) : false;
    }

    public static boolean containsOnly(CharSequence cs, char... valid) {
        if (valid != null && cs != null) {
            if (cs.length() == 0) {
                return true;
            } else if (valid.length == 0) {
                return false;
            } else {
                return indexOfAnyBut(cs, valid) == -1;
            }
        } else {
            return false;
        }
    }

    public static int indexOfAnyBut(CharSequence cs, char... searchChars) {
        if (!isEmpty(cs) && !ArrayUtils.isEmpty(searchChars)) {
            int csLen = cs.length();
            int csLast = csLen - 1;
            int searchLen = searchChars.length;
            int searchLast = searchLen - 1;

            label38:
            for (int i = 0; i < csLen; ++i) {
                char ch = cs.charAt(i);

                for (int j = 0; j < searchLen; ++j) {
                    if (searchChars[j] == ch && (i >= csLast || j >= searchLast || !Character.isHighSurrogate(ch) || searchChars[j + 1] == cs.charAt(i + 1))) {
                        continue label38;
                    }
                }

                return i;
            }

            return -1;
        } else {
            return -1;
        }
    }

    public static int length(CharSequence cs) {
        return cs == null ? 0 : cs.length();
    }

}
