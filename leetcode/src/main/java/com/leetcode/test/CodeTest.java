package com.leetcode.test;

import com.leetcode.code.ListNode;
//import com.leetcode.code.TwoNumsAdd;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CodeTest {

    @Test
    public void testAdd2Nums(){
        //342+564
//        //2->4->3
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//        //4->6->5
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
//        ListNode node = TwoNumsAdd.addTwoNumbers(l1, l2);
        System.out.println("end");
    }
    @Test
    public void testEuler(){
        int m = 65537;
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
        if(1 == euler(m,d,1)) {
            System.out.print(d+",");
            return true;
        }
        return false;
    }
    //-1 : 参数错误; 1 : a,b 互质; m : a,b最大公约数为m
    int euler(int a, int b,int k){
//        if(a < b || a <= 0 || b <= 0 || k < 1)
//            return -1;
        int temp = a - k * b;
        if (0 == temp)
        {
            return b;
        }else if (temp > b)
        {
            k ++;
            return euler(a,b,k);
        }else
        {
            return euler(b, temp, 1);
        }
    }

}
