package com.saraad.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: ProductVo
 * @Package:com.saraad.entity.vo
 * @Description:
 * @author: bin.peng
 * @date: 2018/11/718:02
 * @Copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
@ApiModel("商品Vo")
@Data
public class ProductVo {

    @ApiModelProperty(value = "主键Id",hidden = true)
    private Long id;

    @ApiModelProperty("商品名称")
    private String name;

    @ApiModelProperty("商品编号")
    private String productCode;

    @ApiModelProperty("备注")
    private String remark;

    public ProductVo() {
    }

    public ProductVo(Long id, String name, String productCode, String remark) {
        this.id = id;
        this.name = name;
        this.productCode = productCode;
        this.remark = remark;
    }
}
