package com.leetcode.code;

import com.leetcode.recursion.TailInvoke;
import com.leetcode.recursion.TailRecursion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: BitOprationImplAdd
 * @Package:com.leetcode.code
 * @Description:
 * @author: bin.peng
 * @date: 2018/12/28 10:51
 * @Copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
@RunWith(JUnit4.class)
public class BitOprationImplAdd {

    @Test
    public void testAdd(){
        int sum1 = getSumWithoutPlus(12,7);
        System.out.println(sum1);
        int sum2 = getSumWithoutPlus(0,9);
        System.out.println(sum2);
        int sum3 = getSumWithoutPlus(0,-9);
        System.out.println(sum3);
        int sum4 = getSumWithoutPlus(-25,10);
        System.out.println(sum4);
        int sum5 = getSumWithoutPlus(-25,-30);
        System.out.println(sum5);
    }

    private int getSumWithoutPlus(int a, int b) {
        //计算两数之和,忽略进位1+1=10=0  0+0=0 1+0=0+1=1
        int sum = a ^ b;
        //计算进位 进位不为0左移一位与sum相加
        int carry = (a & b) << 1;
        if (0 == carry){
            return sum;
        }
        return getSumWithoutPlus(sum,carry);
    }

    @Test
    public void testAddTR(){
        int sum1 = getSumUseTR(12,7).invoke().intValue();
        System.out.println(sum1);
        int sum2 = getSumUseTR(0,9).invoke().intValue();
        System.out.println(sum2);
        int sum3 = getSumUseTR(0,-9).invoke().intValue();
        System.out.println(sum3);
        int sum4 = getSumUseTR(-25,10).invoke().intValue();
        System.out.println(sum4);
        int sum5 = getSumUseTR(-25,-30).invoke().intValue();
        System.out.println(sum5);
    }
    TailRecursion<Integer> getSumUseTR(int a,int b){
        int sum = a ^ b;
        int carry = (a & b) << 1;
        if (0 == carry) {
            return TailInvoke.done(sum);
        }
        return TailInvoke.call(()->getSumUseTR(sum,carry));
    }


}
