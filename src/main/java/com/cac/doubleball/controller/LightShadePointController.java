package com.cac.doubleball.controller;

import com.cac.doubleball.service.LightShadePointService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Arrays;
import java.util.List;

/**
 * @author CaoYongCheng
 */
@RestController
@Api(description = "明暗点方式预测")
public class LightShadePointController {

    private LightShadePointService lightShadePointService;

    @Autowired
    public LightShadePointController(LightShadePointService lightShadePointService) {
        this.lightShadePointService = lightShadePointService;
    }

    @ApiOperation(value = "通过球号进行预测", response = List.class)
    @ApiImplicitParam(name = "balls", value = "7个双色球号,以逗号风格", required = true, dataTypeClass = String.class)
    @GetMapping("/light_shade_point/")
    public HttpEntity<?> forecast(@Valid @Pattern(regexp = "^([1-33],)[1-16]$") @NotBlank @RequestParam String balls) {
        String[] strBalls = balls.split(",");
        int[] intBalls = Arrays.stream(strBalls).mapToInt(Integer::parseInt).toArray();
        List<Integer> forecastBalls = lightShadePointService.forecastNextByBalls(intBalls);
        return new ResponseEntity<>(forecastBalls, HttpStatus.OK);
    }
}
