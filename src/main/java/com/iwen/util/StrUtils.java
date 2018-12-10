package com.iwen.util;

/**
 * Created by Administrator on 2018/12/10.
 */
public class StrUtils {

    /**
     * 截取字符串的前limit个字符
     *
     * @param string
     *            原字符串
     * @param limit
     *            截取长度
     * @return String
     */
    public static String sub(String string, int limit) {
        StringBuffer returnString = new StringBuffer();
        if (string == null || limit <= 0 || limit > string.length()) {
            return string;
        }
        char[] temp = string.toCharArray();
        for (int i = 0; i < limit; i++) {
            returnString.append(temp[i]);
        }
        return returnString.toString();
    }
    /**
     * author jwb
     *
     * @param arry
     * @return
     */
    public static String arr2Str(int[] arry) {
        StringBuilder sb = new StringBuilder();
        if (arry != null && arry.length > 0) {
            sb.append("(");
            for (Object object : arry) {
                sb.append(object + ",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(")");
        }
        return sb.toString();
    }

    /**
     * author jwb
     *
     * @param arry
     * @return
     */
    public static String arr2Str(String[] arry) {
        StringBuilder sb = new StringBuilder();
        if (arry != null && arry.length > 0) {
            sb.append("(");
            for (Object object : arry) {
                sb.append(object + ",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(")");
        }
        return sb.toString();
    }

    /**
     * author jwb
     *
     * @param s
     * @return
     */
    public static int str2int(String s) {
        try {
            return Integer.valueOf(s.trim());
        } catch (Exception e) {
            return 0;
        }
    }
}
