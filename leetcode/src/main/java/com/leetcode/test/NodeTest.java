package com.leetcode.test;

import com.leetcode.code.ListNode;

/**
 * All rights Reserved, Designed By SARAAD
 *
 * @version V1.0
 * @Title: NodeTest
 * @Package:com.leetcode.test
 * @Description: 倒序打印链表  使用栈结构实现,先入后出   递归特性满足栈结构
 * @author: saraad
 * @date: 2019/1/3 2:26
 * @Copyright: 2019  Inc. All rights reserved.
 * PROJECT FOR PRACTICE
 */
public class NodeTest {

    public static void main(String[] args){
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(7);
        l1.next.next.next = new ListNode(0);
        printNodeReverse(l1);
        printNodeReverse(null);
//        printNodeReverse(new ListNode());
    }

    //倒序打印链表
    static void printNodeReverse(ListNode node){
        if (null == node){
            System.out.println("链表为null");
            return;
        }
        if (null != node.next){
            printNodeReverse(node.next);
        }else {
            System.out.println("开始打印");
        }
        System.out.printf("node.val = %s\n",node.getVal());
    }

}
