package com.cac.doubleball.autoconfig;

import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @author CaoYongCheng
 */
@Configuration
public class LightShadePointConfiguration {
    private HashMap<Integer, int[]> map;

    public LightShadePointConfiguration() {
        map = new HashMap<>();
        map.put(1, new int[]{1, 6, 10, 15, 19, 24, 28, 33});
        map.put(2, new int[]{2, 7, 11, 16, 20, 25, 29});
        map.put(3, new int[]{3, 8, 12, 17, 21, 26, 30});
        map.put(4, new int[]{4, 9, 13, 18, 22, 27, 31});
        map.put(5, new int[]{5, 14, 23, 32});

        map.put(6, map.get(1));
        map.put(7, map.get(2));
        map.put(8, map.get(3));
        map.put(9, map.get(4));
        map.put(0, map.get(5));
    }

    public int[] getBalls(int key) {
        return map.get(key);
    }

}
