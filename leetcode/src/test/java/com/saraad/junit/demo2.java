package com.saraad.junit;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * All rights Reserved, Designed By SARAAD
 *
 * @version V1.0
 * @Title: demo2
 * @Package:com.saraad.junit
 * @Description:
 * @author: saraad
 * @date: 2019/2/21 19:23
 * @Copyright: 2019  Inc. All rights reserved.
 * PROJECT FOR PRACTICE
 */
public class demo2 {

    public static void main(String[] args){
        long l1 = System.currentTimeMillis();
        //构造原始数据
        String s = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] words = s.toCharArray();
        //new 俩全局变量 set保证不重复
        Random random = new Random();
        HashSet<String> set = new HashSet<>();
        while (set.size()<10) {
            //每次循环生成一个新的字符串
            char[] temp = new char[10];
            for (int i = 0; i <10 ; i++) {
               int index = random.nextInt(s.length());
               temp[i] = words[index] ;
            }
            set.add(new String(temp));
        }
        //打印...
        set.forEach(System.out::println);
        System.out.println(System.currentTimeMillis()-l1);
    }

}
