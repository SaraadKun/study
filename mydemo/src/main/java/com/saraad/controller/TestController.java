package com.saraad.controller;

import com.saraad.entity.base.BaseResponse;
import com.saraad.entity.vo.ProductVo.ProductVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation("新增")
    @PostMapping("/add")
    public BaseResponse<ProductVo> add(@RequestBody ProductVo productVo){

        return null;
    }

    @ApiOperation("查询")
    @GetMapping("/query")
    public BaseResponse<List<ProductVo>> query(){

        return null;
    }




}
