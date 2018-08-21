package com.cac.doubleball.enums;

import com.cac.doubleball.util.NumberUtils;

/**
 * @author CaoYongCheng
 */
public enum LightShadePointTypeEnum {

    /**
     * 明点，将每个数字计算出来的数位值，进行相加
     */
    LIGHT {
        @Override
        public int exec(int[] values) {
            int sumValue = 0;
            for (int addValue : values) {
                sumValue += LightShadePointTypeEnum.digitAdd(addValue);
            }
            return sumValue;
        }
    },

    /**
     * 暗点，将每个数字计算出来的数位值（如果数位值为10，直接变成1），进行相加
     */
    SHADE {
        @Override
        public int exec(int[] values) {
            int originalValue;
            int sumValue = 0;
            for (int addValue : values) {
                originalValue = LightShadePointTypeEnum.digitAdd(addValue);
                sumValue += (originalValue == 10 ? 1 : originalValue);
            }
            return sumValue;
        }
    },;

    public abstract int exec(int[] values);

    /**
     * 将数字各数位上的值分别相加后得到一个新的数字，直到该值小于或等于10 </br>
     * 例如：175  第一次 1+7+5=13  第二次  1+3=4  所以结果为4
     *
     * @param value 数字
     * @return 数位和，小于或等于10
     */
    private static int digitAdd(int value) {
        int digitNum = value;
        while (digitNum > 10) {
            digitNum = NumberUtils.digitAdd(digitNum);
        }
        return digitNum;
    }
}
