package com.cac.doubleball.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        lightShadePointService.forecastNextByBalls(balls);
    }
}
