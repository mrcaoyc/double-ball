package com.cac.doubleball.service.impl;

import com.cac.doubleball.autoconfig.LightShadePointConfiguration;
import com.cac.doubleball.consts.DoubleBallConst;
import com.cac.doubleball.enums.LightShadePointOperatorEnum;
import com.cac.doubleball.enums.LightShadePointTypeEnum;
import com.cac.doubleball.service.LightShadePointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author CaoYongCheng
 */
@Service
public class LightShadePointServiceImpl implements LightShadePointService {

    private LightShadePointConfiguration lightShadePointConfiguration;

    @Autowired
    public LightShadePointServiceImpl(LightShadePointConfiguration lightShadePointConfiguration) {
        this.lightShadePointConfiguration = lightShadePointConfiguration;
    }

    @Override
    public List<Integer> forecastNextByBalls(int[] balls) {
        if (Objects.isNull(balls) || balls.length != DoubleBallConst.BALL_COUNT) {
            return new ArrayList<>();
        }
        //计算加减乘除明暗点
        int addLightPoint = LightShadePointOperatorEnum.ADD.exec(balls, LightShadePointTypeEnum.LIGHT);
        int addShadePoint = LightShadePointOperatorEnum.ADD.exec(balls, LightShadePointTypeEnum.SHADE);
        int subtractLightPoint = LightShadePointOperatorEnum.SUBTRACT.exec(balls, LightShadePointTypeEnum.LIGHT);
        int subtractShadePoint = LightShadePointOperatorEnum.SUBTRACT.exec(balls, LightShadePointTypeEnum.SHADE);
        int multiplyLightPoint = LightShadePointOperatorEnum.MULTIPLY.exec(balls, LightShadePointTypeEnum.LIGHT);
        int multiplyShadePoint = LightShadePointOperatorEnum.MULTIPLY.exec(balls, LightShadePointTypeEnum.SHADE);

        //计算明暗点和
        int lightPointSum = addLightPoint + subtractLightPoint + multiplyLightPoint;
        int shadePointSum = addShadePoint + subtractShadePoint + multiplyShadePoint;

        //分别取明暗点从左边开始第一位，然后从关系配置表中得到可能的值。
        int firstLightPoint = Integer.parseInt(Integer.toString(lightPointSum).substring(0, 1));
        int firstShadePoint = Integer.parseInt(Integer.toString(shadePointSum).substring(0, 1));

        int[] lightPointBalls = lightShadePointConfiguration.getBalls(firstLightPoint);
        int[] shadePointBalls = lightShadePointConfiguration.getBalls(firstShadePoint);

        HashSet<Integer> forecastSet = new HashSet<>();
        for (int value : lightPointBalls) {
            forecastSet.add(value);
        }
        for (int value : shadePointBalls) {
            forecastSet.add(value);
        }
        return new ArrayList<>(forecastSet).stream().sorted().collect(Collectors.toList());
    }
}
