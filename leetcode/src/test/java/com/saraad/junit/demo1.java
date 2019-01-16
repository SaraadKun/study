package com.saraad.junit;

import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.Field;
import java.util.UUID;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: demo1
 * @Package:com.saraad.junit
 * @Description:
 * @author: bin.peng
 * @date: 2018/12/29 14:32
 * @Copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
//@RunWith(JUnit4.class)
public class demo1 {


//    @Test
    public void testInt(){
        int a = 5548;
        Integer b1 = new Integer(5548);
        Integer b2 = new Integer(5548);
        assert a == b1;
        assert a == b2;
//        assert b1 == b2;//false


    }


    public static void main(String[] args){
//        int i = sum1(11);
        int i = sum2(11,11+1)>>1;
        System.out.println(i);
    }

    public static int sum2(int n,int m){
        int result = 0;
        boolean a = (n&1)==1&&(result += m)>0;
        boolean b = n > 0 && (result +=sum2(n>>1,m<<1))>0;
         return result;
    }
    public static int sum1(int n){
        int m = n+1,count = -1,result = 0;
        while (n != 0){
            count++;
            boolean flag = (n & 1) == 1 &&result ==(result += m << count);
            n = n >> 1;
        }
        return result >> 1;
    }

//    @Test
    public void sss(){
//        Double d = 2.1;
//        int ceil = (int)Math.floor(d*100);
//        System.out.println(ceil);
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
    }

//    @Test
    public void testInteger(){

        Integer a = 100;
        Integer b = 129;
        System.out.printf("a = %d, b = %d\n",a,b);
        swap(a,b);
        System.out.printf("a = %d, b = %d\n",a,b);
    }

    public void swap(Integer a, Integer b){
        final int temp = a.intValue();
        Class clazz = Integer.class;
        try {
            Field field = clazz.getDeclaredField("value");
            field.setAccessible(true);
            field.set(a,b);
//            field.set(b,temp);
            field.set(b,new Integer(temp));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void swap0(Integer a, Integer b){
        Integer temp = Integer.valueOf(a.intValue());
        a = b;
        b = temp;
    }

}
