package com.chinaweal.auto.utils;

import org.apache.commons.lang.StringUtils;

/**
 * Created by Lain on 2016/11/5.
 */
public class StrUtils {
    public static String capitalFirstChar(String str) {
        String resultStr = "";
        str = StringUtils.trimToEmpty(str);
        if (str.length() == 1) {
            resultStr = StringUtils.capitalize(str);
        } else{
        }
        return resultStr;
    }

    public static void main(String[] args) {
        System.out.println(StringUtils.capitalize("hello"));
    }
}
