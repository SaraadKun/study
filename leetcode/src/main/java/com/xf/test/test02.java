package com.xf.test;

//分析以下需求，并用代码实现
//	1.产生10个1-20之间的随机数要求随机数不能重复
//	2.产生10个长度为10的不能重复的字符串(里面只能出现大写字母、小写字母、0-9的数字)，并遍历打印输出

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Random;

public class test02 {

    public static void main(String[] args) {
        Random r = new Random();
        LinkedHashSet<Integer> lhs1 = new LinkedHashSet<Integer>(10);
        while (lhs1.size()<10){
            int num = r.nextInt(20) + 1;
            lhs1.add(num);
        }

        LinkedHashMap<Integer,Character> lhm = new LinkedHashMap<>();
        LinkedHashSet<String> lhs2 = new LinkedHashSet<String>();
        StringBuilder sb = new StringBuilder(10);

        String s = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        long l1 = System.currentTimeMillis();
        while (lhs2.size()<10){
            String str = getString(s, lhm);
            lhs2.add(str);
        }
        System.out.println(System.currentTimeMillis()-l1);

        print(lhs1);
        print(lhs2);
    }

    public static String getString(String s , LinkedHashMap<Integer,Character> lhm){
        Random r = new Random();
        String s1 = "";
//        for (int i1 = 0; i1 < s.length(); i1++) {
//            lhm.put(i1,s.charAt(i1));
//        }

        for (int i = 0; i < 10; i++) {
//            int size1 = r.nextInt(lhm.size()) + 1;
//            Character ch = lhm.get(size1);
            int size1 = r.nextInt(s.length());
            Character ch = s.charAt(size1);
            s1 += ch + "";
        }
        return s1;
    }

    public static void print(LinkedHashSet lhs){
        for (Object lh : lhs) {
            System.out.print(lh + " ");
        }
        System.out.println();
    }
}


