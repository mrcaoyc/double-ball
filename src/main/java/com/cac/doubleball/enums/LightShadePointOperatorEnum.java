package com.cac.doubleball.enums;

import com.cac.doubleball.consts.DoubleBallConst;

import java.util.Arrays;

/**
 * @author CaoYongCheng
 */
public enum LightShadePointOperatorEnum {

    /**
     * 和值运算，计算蓝球与每个红球的和
     */
    ADD {
        @Override
        public int exec(int[] balls, LightShadePointTypeEnum lightShadePointTypeEnum) {
            int[] addValues = Arrays.stream(balls).limit(DoubleBallConst.BALL_COUNT - 1)
                    .map(value -> balls[DoubleBallConst.BALL_COUNT - 1] + value).toArray();
            return lightShadePointTypeEnum.exec(addValues);
        }
    },

    /**
     * 差值运算，计算蓝球与每个红球差的绝对值
     */
    SUBTRACT {
        @Override
        public int exec(int[] balls, LightShadePointTypeEnum lightShadePointTypeEnum) {
            int[] addValues = Arrays.stream(balls).limit(DoubleBallConst.BALL_COUNT - 1)
                    .map(value -> Math.abs(balls[DoubleBallConst.BALL_COUNT - 1] - value)).toArray();
            return lightShadePointTypeEnum.exec(addValues);
        }
    },

    /**
     * 乘积运算，计算蓝球与每个红球的积
     */
    MULTIPLY {
        @Override
        public int exec(int[] balls, LightShadePointTypeEnum lightShadePointTypeEnum) {
            int[] addValues = Arrays.stream(balls).limit(DoubleBallConst.BALL_COUNT - 1)
                    .map(value -> balls[DoubleBallConst.BALL_COUNT - 1] * value).toArray();
            return lightShadePointTypeEnum.exec(addValues);
        }
    };

    public abstract int exec(int[] balls, LightShadePointTypeEnum lightShadePointTypeEnum);
}
