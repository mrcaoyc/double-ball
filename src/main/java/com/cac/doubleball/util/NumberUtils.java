package com.cac.doubleball.util;

/**
 * @author CaoYongCheng
 */
public class NumberUtils {

    /**
     * 将数字的上各数值进行相加
     *
     * @param number 数字
     * @return 数位和
     */
    public static int digitAdd(int number) {
        int digitNum = 0;
        String originalStr = number + "";
        for (int digit = 0; digit <= originalStr.length(); digit++) {
            digitNum += ((number / Math.pow(10, digit)) % 10);
        }
        return digitNum;
    }
}
