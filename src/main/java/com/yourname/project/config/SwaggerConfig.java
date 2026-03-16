package com.yourname.project.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger 配置类
 */
@Configuration
@EnableKnife4j
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        // 添加全局请求头参数
        List<ParameterBuilder> parameterBuilders = new ArrayList<>();
        ParameterBuilder tokenParam = new ParameterBuilder()
                .name("Authorization")
                .description("JWT Token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        parameterBuilders.add(tokenParam);

        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yourname.project.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalParameters(parameterBuilders);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("项目 API 文档")
                .description("Spring Boot 项目 RESTful API")
                .contact(new Contact("YourName", "", "your@email.com"))
                .version("1.0.0")
                .build();
    }

}
