package com.cac.doubleball.autoconfig;

import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author CaoYongCheng
 */
@Configuration
public class SwaggerConfiguration {
    @Value("${swagger.host}")
    private String host;

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .host(host)
                .apiInfo(apiInfo())
                .select()
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("双色球预测")
                .contact(new Contact("曹哥", "", "mrcaoyc@163.com"))
                .description("双色球预测，结果仅供参考，不承担任何法律责任")
                .version("v1.0")
                .build();
    }
}
