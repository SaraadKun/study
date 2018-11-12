package com.saraad;

import com.saraad.config.SwaggerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * All rights Reserved, Designed By SARAAD
 *
 * @version V1.0
 * @Title: Swagger2cfg
 * @Package:com.saraad
 * @Description:
 * @author: saraad
 * @date: 2018/11/8 8:25
 * @Copyright: 2018  Inc. All rights reserved.
 * PROJECT FOR PRACTICE
 */
@Configuration
@EnableSwagger2
public class Swagger2cfg {

    @Autowired
    private SwaggerProperties properties;

    //swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage(properties.getBasepackage()))
                .paths(PathSelectors.any())
                .build();
    }
    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title(properties.getTitle())
                //创建人
                .contact(new Contact("Saraad", "=_=", "saraad@163.com"))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }
}
