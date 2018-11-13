package com.saraad.dao;

import com.saraad.common.util.IdWorker;
import com.saraad.entity.vo.ProductVo.ProductVo;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * All rights Reserved, Designed By SARAAD
 *
 * @version V1.0
 * @Title: ProductDao
 * @Package:com.saraad.dao
 * @Description:
 * @author: saraad
 * @date: 2018/11/8 7:11
 * @Copyright: 2018  Inc. All rights reserved.
 * PROJECT FOR PRACTICE
 */
@Repository
public class ProductDao {

    static {
        ArrayList<ProductVo> products = new ArrayList<>();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> fa51c670b35efebc87aaba50e5e64f5af288b647
=======
>>>>>>> a05eac5adefc3301129f608bd7df04afeadcfd26
        try {
            products.add(new ProductVo(IdWorker.generateId(), "product_01", "10001", "初始商品1"));
            Thread.sleep(1);
            products.add(new ProductVo(IdWorker.generateId(), "product_02", "10002", "初始商品2"));
            Thread.sleep(1);
            products.add(new ProductVo(IdWorker.generateId(), "product_03", "10003", "初始商品3"));
        } catch (InterruptedException e) {

        }
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> a05eac5adefc3301129f608bd7df04afeadcfd26
=======
        products.add(new ProductVo(IdWorker.generateId(), "product_01", "10001", "初始商品1"));
        products.add(new ProductVo(IdWorker.generateId(), "product_02", "10002", "初始商品2"));
        products.add(new ProductVo(IdWorker.generateId(), "product_03", "10003", "初始商品3"));
>>>>>>> 791173b9be1a914c82554e2e1131c9a4fcdb5e3e
<<<<<<< HEAD
=======
>>>>>>> fa51c670b35efebc87aaba50e5e64f5af288b647
=======
>>>>>>> a05eac5adefc3301129f608bd7df04afeadcfd26
        list = products;
    }

    private static final List<ProductVo> list;

    /**
     * add
     * @param productVo
     * @return
     */
    public Integer add(final ProductVo productVo){
        if (null == productVo) return 0;
        if (null == productVo.getId()) return 0;
        //查看当前id的productVo是否已存在
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> fa51c670b35efebc87aaba50e5e64f5af288b647
=======
>>>>>>> a05eac5adefc3301129f608bd7df04afeadcfd26
//        Stream<ProductVo> stream = list.stream().filter(p -> p.getId().longValue() == productVo.getId().longValue());
//        List<ProductVo> exsitList = stream.collect(Collectors.toList());
        List<ProductVo> exsitList = list.stream().filter(p -> p.getId().longValue() == productVo.getId().longValue()).collect(Collectors.toList());
//        ArrayList<ProductVo> exsitList = new ArrayList<>();
//        for (ProductVo vo : list) {
//            if (productVo.getId().longValue() == vo.getId().longValue())
//                exsitList.add(vo);
//        }
<<<<<<< HEAD
<<<<<<< HEAD
=======
        List<ProductVo> exsitList = list.stream().filter(p -> p.getId().longValue() == productVo.getId().longValue()).collect(Collectors.toList());
>>>>>>> 791173b9be1a914c82554e2e1131c9a4fcdb5e3e
=======
>>>>>>> fa51c670b35efebc87aaba50e5e64f5af288b647
=======
=======
        List<ProductVo> exsitList = list.stream().filter(p -> p.getId().longValue() == productVo.getId().longValue()).collect(Collectors.toList());
>>>>>>> 791173b9be1a914c82554e2e1131c9a4fcdb5e3e
>>>>>>> a05eac5adefc3301129f608bd7df04afeadcfd26
        if (!CollectionUtils.isEmpty(exsitList))
            return 0;
        list.add(productVo);
        return 1;
    }

    public List<ProductVo> queryAll(){
        return list;
    }



}
