package com.leetcode.test;

import com.leetcode.recursion.TailInvoke;
import com.leetcode.recursion.TailRecursion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigInteger;
import java.util.stream.Stream;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: StreamTest
 * @Package:com.leetcode.test
 * @Description:
 * @author: bin.peng
 * @date: 2018/12/12 15:21
 * @Copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
@RunWith(JUnit4.class)
public class StreamTest {

    @Test
    public void testIf(){
        int number = 1;

    }

    @Test
    public void testNum(){

        BigInteger temp = new BigInteger("1");
        BigInteger d = new BigInteger("2790");
        BigInteger n = new BigInteger("3233");
        for (int i = 0; i < 2753; i++) {
            temp = temp.multiply(d);
        }
        BigInteger mod = temp.mod(n);
        System.out.println(mod);
    }


    @Test
    public void testEuler(){
        int m = 2790;
        boolean bl;
        int count = 0;
        for (int i = 1; i < m ; i++) {
            if (bl = isCoprime(m,i)) {
                count++;
            }
        }
        System.out.println();
        System.out.println(count);
    }
    //true 互质 false 不互质
    boolean isCoprime(int m, int d){
        if(1 == euler(m,d,1).invoke().intValue()) {
            System.out.print(d+",");
            return true;
        }
        return false;
    }
    //-1 : 参数错误; 1 : a,b 互质; m : a,b最大公约数为m
    TailRecursion<Integer> euler(final Integer a, final Integer b, final Integer k){
        if(a < b || a <= 0 || b <= 0 || k < 1)
           throw new RuntimeException("递归参数非法!");
        int temp = a - k * b;
        if (0 == temp)
        {
            return TailInvoke.done(b);
        }else if (temp > b)
        {
            return TailInvoke.call(() -> euler(a,b,k+1));
//            return euler(a,b,k+1); 此处必须用尾递归接口表示,否则仍然会StackOverflow
        }else
        {
            return TailInvoke.call(() -> euler(b, temp, 1));
//            return euler(a,b,1);
        }
    }

}
