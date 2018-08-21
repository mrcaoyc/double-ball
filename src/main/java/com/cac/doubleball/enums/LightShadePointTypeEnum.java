package com.cac.doubleball.enums;

/**
 * @author CaoYongCheng
 */
public enum LightShadePointTypeEnum {

    /**
     * 明点
     */
    LIGHT {
        @Override
        public int exec(int[] values) {
            int originalValue;
            int singleDigit;
            int tenDigit;
            int sumValue = 0;
            for (int addValue : values) {
                originalValue = addValue;
                while (originalValue > 10) {
                    tenDigit = originalValue / 10;
                    singleDigit = originalValue - tenDigit * 10;
                    originalValue = tenDigit + singleDigit;
                }
                sumValue += originalValue;
            }
            return sumValue;
        }
    },

    /**
     * 暗点
     */
    SHADE {
        @Override
        public int exec(int[] values) {
            int originalValue;
            int singleDigit;
            int tenDigit;
            int sumValue = 0;
            for (int addValue : values) {
                originalValue = addValue;
                while (originalValue > 10) {
                    tenDigit = originalValue / 10;
                    singleDigit = originalValue - tenDigit * 10;
                    originalValue = tenDigit + singleDigit;
                }
                sumValue += (originalValue == 10 ? 1 : originalValue);
            }
            return sumValue;
        }
    },;

    public abstract int exec(int[] values);
}
