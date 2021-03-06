package com.saraad.controller;

import com.saraad.entity.base.BaseResponse;
import com.saraad.entity.vo.ProductVo;
import com.saraad.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: TestController
 * @Package:com.saraad.controller
 * @Description:
 * @author: bin.peng
 * @date: 2018/11/716:12
 * @Copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
@Api(tags = "商品服务")
@RestController
@RequestMapping("/product")
public class TestController {

    private ProductService productService;

    @Autowired
    public TestController(ProductService productService) {
        this.productService = productService;
    }

    @ApiOperation("新增")
    @PostMapping("/add")
    public BaseResponse add(@RequestBody ProductVo productVo){
        return productService.add(productVo);
    }

    @ApiOperation("查询")
    @GetMapping("/query")
    public BaseResponse<List<ProductVo>> query(){
        System.out.println("query");
        return productService.queryAll();
    }

    @ApiOperation("测试新增")
    @PostMapping("/addTest")
    public BaseResponse addTest(@RequestBody ProductVo productVo){
        return productService.addTest(productVo);
    }


}
