package com.leetcode.code;

import java.util.ArrayList;
import java.util.List;

/**
 * All rights Reserved, Designed By SARAAD
 *
 * @version V1.0
 * @Title: ArrayRepeatNum
 * @Package:com.leetcode.code
 * @Description: 求数组中重复的数字 <<剑指offer>> p39  topic 3
 * @author: saraad
 * @date: 2018/12/29 5:11
 * @Copyright: 2018  Inc. All rights reserved.
 * PROJECT FOR PRACTICE
 */
public class ArrayRepeatNum {

    /**
     * 在一个长度为n的数组里的所有数字都在0~n-1的范围内。
     * 数组中某些数字是重复的，但是不知道有几个数字重复了，也不知道每个数字重复了几次。
     * 请找出数组中任意一个重复的数字。例如，如果输入长度为7,的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数组2或者3。（n个元素，n种可能的取值）
     *
     */
    public static void main(String args[]){
        //双层for循环 时间:O(n²)
        //排序数组 时间:O(nlog(n))
        //hashmap 时间:O(n) 空间O(n)
        //时间O(1)算法
//        int[] arr = {2,3,1,0,2,5,3};
//        int[] arr = {0,1,2,3,4,5,6};
//        int [] arr = null;
        int [] arr = {};
        int num = findRepeatNum(arr);
        System.out.println(num);
        List<Integer> nums = findAllRepeatNum(arr);
        System.out.println(nums.toString());
    }

    private static List<Integer> findAllRepeatNum(int[] arr) {
        if(null == arr || 0 == arr.length){throw new RuntimeException("数组为空");}
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            while (i != arr[i]){
                {
                    int m = arr[i];
                    if (m == arr[m]) {
                        list.add(m);
                        break;
                    }
                    arr[i] = arr[m];
                    arr[m] = m;
                }
            };
        }
        return list;
    }

    private static int findRepeatNum(int[] arr) {
        if(null == arr || 0 == arr.length){throw new RuntimeException("数组为空");}
        for (int i = 0; i < arr.length; i++) {
            while (i != arr[i]){
                {
                    int m = arr[i];
                    if (m == arr[m]) {
                        return m;
                    }
                    arr[i] = arr[m];
                    arr[m] = m;
                }
            };
        }
        return -1;
    }

}
