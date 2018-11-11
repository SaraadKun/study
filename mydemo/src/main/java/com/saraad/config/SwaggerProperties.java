package com.saraad.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * All rights Reserved, Designed By SARAAD
 *
 * @version V1.0
 * @Title: SwaggerProperties
 * @Package:com.saraad.config
 * @Description:
 * @author: saraad
 * @date: 2018/11/8 8:30
 * @Copyright: 2018  Inc. All rights reserved.
 * PROJECT FOR PRACTICE
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "swagger")
public class SwaggerProperties {

    private String basepackage;

    private String title;

}
