package com.leetcode.code;

import java.lang.reflect.Field;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: SwapInteger
 * @Package:com.leetcode.code
 * @Description: swap 2 Integer
 * @author: bin.peng
 * @date: 2019/1/2 16:44
 * @Copyright: 2019 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
public class SwapInteger {

    public static void main(String[] args){
        Integer a = 77,b = 88;
        System.out.printf("a = %s, b = %s\n",a,b);
        swap(a,b);
        System.out.printf("a = %s, b = %s\n",a,b);
    }

    public static void swap(Integer a, Integer b){
        final int temp = a.intValue();
        try {
            Class clz = Integer.class;
            Field value = clz.getDeclaredField("value");
            value.setAccessible(true);
            value.set(a,b);
            value.set(b,new Integer(temp));
        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
