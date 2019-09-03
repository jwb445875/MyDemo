package com.iwen.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tino
 * @version 2018/7/2
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
    @Bean
    public Docket docket() {
        ParameterBuilder builder = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        pars.add(builder.name("authorization").description("authorization").modelRef(new ModelRef("string")).parameterType("header").required(false).build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder().title("PLANNING").build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.iwen"))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(pars);
    }




    /**
     * configurer.setUseSuffixPatternMatch(false)表示系统对外暴露的URL不会识别和匹配URL.* eg: get请求不会匹配到get.do
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }

}
