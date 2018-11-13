package com.saraad.service;

import com.saraad.common.util.IdWorker;
import com.saraad.dao.ProductDao;
import com.saraad.entity.base.BaseResponse;
import com.saraad.entity.vo.ProductVo;
import com.saraad.enums.StatusEnum;
import com.saraad.enums.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * All rights Reserved, Designed By SARAAD
 *
 * @version V1.0
 * @Title: ProductService
 * @Package:com.saraad.service
 * @Description:
 * @author: saraad
 * @date: 2018/11/8 7:11
 * @Copyright: 2018  Inc. All rights reserved.
 * PROJECT FOR PRACTICE
 */

@Service
public class ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    /**
     * add
     * @param productVo
     * @return
     */
    public BaseResponse add(ProductVo productVo){
        productVo.setId(IdWorker.generateId());
        Integer res = productDao.add(productVo);
        if (1 == res){
            return new BaseResponse(Version.VERSION_1.getCode(), StatusEnum.STATUS_100.getCode(),StatusEnum.STATUS_100.getMesssage());
        }
        return new BaseResponse(Version.VERSION_1.getCode(), StatusEnum.STATUS_101.getCode(),StatusEnum.STATUS_101.getMesssage());
    }

    /**
     * query
     * @return
     */
    public BaseResponse<List<ProductVo>> queryAll(){
        List<ProductVo> list = productDao.queryAll();
        return new BaseResponse<>(Version.VERSION_1.getCode(), StatusEnum.STATUS_100.getCode(),StatusEnum.STATUS_100.getMesssage(),list);
    }
    /**
     * add
     * @param productVo
     * @return
     */
    public BaseResponse addTest(ProductVo productVo){
//        productVo.setId(IdWorker.generateId());
        Integer res = productDao.add(productVo);
        if (1 == res){
            return new BaseResponse(Version.VERSION_1.getCode(), StatusEnum.STATUS_100.getCode(),StatusEnum.STATUS_100.getMesssage());
        }
        return new BaseResponse(Version.VERSION_1.getCode(), StatusEnum.STATUS_101.getCode(),StatusEnum.STATUS_101.getMesssage());
    }
}
