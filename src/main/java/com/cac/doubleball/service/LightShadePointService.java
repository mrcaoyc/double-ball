package com.cac.doubleball.service;

import java.util.List;

/**
 * 明暗点预测
 *
 * @author CaoYongCheng
 */
public interface LightShadePointService {

    /**
     * 通过双色球号计算下一期球号
     *
     * @param balls 上一期球号
     * @return 下一期预测球号
     */
    List<Integer> forecastNextByBalls(int[] balls);
}
