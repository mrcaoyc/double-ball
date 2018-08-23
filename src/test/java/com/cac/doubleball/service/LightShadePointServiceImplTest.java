package com.cac.doubleball.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * @author CaoYongCheng
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class LightShadePointServiceImplTest {
    @Autowired
    private LightShadePointService lightShadePointService;

    @Test
    public void forecastNextByBallsTest() {
        int[] balls = new int[]{6, 11, 13, 17, 25, 32, 7};
        List<Integer> expect = Arrays.asList(1, 3, 6, 8, 10, 12, 15, 17, 19, 21, 24, 26, 28, 30, 33);
        List<Integer> result = lightShadePointService.forecastNextByBalls(balls);
        Assert.state(result.containsAll(expect), "result should contains expect");
    }
}
