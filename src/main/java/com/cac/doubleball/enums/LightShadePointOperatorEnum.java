package com.cac.doubleball.enums;

import com.cac.doubleball.model.DoubleBallGroupDTO;

import java.util.Arrays;

/**
 * @author CaoYongCheng
 */
public enum LightShadePointOperatorEnum {

    /**
     * 和值运算
     */
    ADD {
        @Override
        public int exec(int[] balls, LightShadePointTypeEnum lightShadePointTypeEnum) {
            int[] addValues = Arrays.stream(balls).limit(DoubleBallGroupDTO.BALL_COUNT - 1)
                    .map(value -> balls[DoubleBallGroupDTO.BALL_COUNT - 1] + value).toArray();
            return lightShadePointTypeEnum.exec(addValues);
        }
    },

    /**
     * 差值运算
     */
    SUBTRACT {
        @Override
        public int exec(int[] balls, LightShadePointTypeEnum lightShadePointTypeEnum) {
            int[] addValues = Arrays.stream(balls).limit(DoubleBallGroupDTO.BALL_COUNT - 1)
                    .map(value -> Math.abs(balls[DoubleBallGroupDTO.BALL_COUNT - 1] - value)).toArray();
            return lightShadePointTypeEnum.exec(addValues);
        }
    },

    /**
     * 乘积运算
     */
    MULTIPLY {
        @Override
        public int exec(int[] balls, LightShadePointTypeEnum lightShadePointTypeEnum) {
            int[] addValues = Arrays.stream(balls).limit(DoubleBallGroupDTO.BALL_COUNT - 1)
                    .map(value -> balls[DoubleBallGroupDTO.BALL_COUNT - 1] * value).toArray();
            return lightShadePointTypeEnum.exec(addValues);
        }
    };

    public abstract int exec(int[] balls, LightShadePointTypeEnum lightShadePointTypeEnum);
}
