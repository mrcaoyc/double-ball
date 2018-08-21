package com.cac.doubleball.service.impl;

import com.cac.doubleball.enums.LightShadePointOperatorEnum;
import com.cac.doubleball.enums.LightShadePointTypeEnum;
import com.cac.doubleball.model.DoubleBallGroupDTO;
import com.cac.doubleball.service.LightShadePointService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author CaoYongCheng
 */
@Service
public class LightShadePointServiceImpl implements LightShadePointService {
    @Override
    public List<DoubleBallGroupDTO> forecastNextByBalls(int[] balls) {
        if (Objects.isNull(balls) || balls.length != DoubleBallGroupDTO.BALL_COUNT) {
            return new ArrayList<>();
        }
        int addLightPoint = LightShadePointOperatorEnum.ADD.exec(balls, LightShadePointTypeEnum.LIGHT);
        int addShadePoint = LightShadePointOperatorEnum.ADD.exec(balls, LightShadePointTypeEnum.SHADE);
        int subtractLightPoint = LightShadePointOperatorEnum.SUBTRACT.exec(balls, LightShadePointTypeEnum.LIGHT);
        int subtractShadePoint = LightShadePointOperatorEnum.SUBTRACT.exec(balls, LightShadePointTypeEnum.SHADE);
        int multiplyLightPoint = LightShadePointOperatorEnum.MULTIPLY.exec(balls, LightShadePointTypeEnum.LIGHT);
        int multiplyShadePoint = LightShadePointOperatorEnum.MULTIPLY.exec(balls, LightShadePointTypeEnum.SHADE);
        int lightPointSum = addLightPoint + subtractLightPoint + multiplyLightPoint;
        int shadePointSum = addShadePoint + subtractShadePoint + multiplyShadePoint;

        return null;
    }


}
