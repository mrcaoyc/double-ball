package com.cac.doubleball.controller;

import com.cac.doubleball.model.DoubleBallGroupDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CaoYongCheng
 */
@RestController
@Api(description = "明暗点方式预测")
public class LightShadePointController {

    @ApiOperation(value = "通过双色球号进行预测",response = DoubleBallGroupDTO.class)
    @GetMapping("/light_shade_point/")
    public HttpEntity<?> forecast(Integer[] balls){
        return null;
    }

}
