package com.saraad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: ProductApplication
 * @Package:com.saraad
 * @Description:
 * @author: bin.peng
 * @date: 2018/11/7 18:30
 * @Copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */

@ComponentScan({"com.saraad","com.freemud"})
@SpringBootApplication
public class ProductApplication {

    public static void main(String[] args){
        SpringApplication.run(ProductApplication.class);
    }

}
