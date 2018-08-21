package com.cac.doubleball;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author CaoYongCheng
 */
@SpringBootApplication
@EnableSwagger2
public class DoubleBallApp {
    public static void main(String[] args) {
        SpringApplication.run(DoubleBallApp.class, args);
    }
}
