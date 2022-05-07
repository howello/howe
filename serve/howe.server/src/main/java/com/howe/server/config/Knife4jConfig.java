package com.howe.server.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * <p>@Author lu
 * <p>@Date 2022/5/7 17:30 星期六
 * <p>@Version 1.0
 * <p>@Description
 */
@Configuration
@EnableKnife4j
@EnableOpenApi
public class Knife4jConfig {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .groupName("Howe-ServerV0.1")
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.howe.server.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Howe-Server文档")
                .description("博客后端文档")
                .version("0.1")
                .build();
    }
}
