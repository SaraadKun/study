package com.leetcode.code;


/**
 * @Title:两数相加
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class TwoNumsAdd {


    //V1.0
    public static ListNode addTwoNumbersOld(ListNode l1, ListNode l2) {
        //首位非空判断不做
        //付初始值
        int sum = l1.val + l2.val;
        int thisNum = sum % 10;
        int nextNum = sum / 10;
        ListNode result = new ListNode(thisNum);
        ListNode node = result;
        while (null != l1.next){
            l1 = l1.next;
//            l2 = l2.next;  l2可能为null,空指针
            if(null != l2 && null != l2.next) {
                l2 = l2.next;
                sum = l1.val + l2.val + nextNum;
            }else {
                sum = l1.val + nextNum;
            }
            thisNum = sum % 10;
            nextNum = sum / 10;
            //进位相加判断
            node.next = new ListNode(thisNum);
            node = node.next;
        }
//        while (l2.next != null){ 这里若l2为null,会报空指针
        while (null != l2 && null != l2.next){
            l2 = l2.next;
            sum = l2.val + nextNum;
            thisNum = sum % 10;
            nextNum = sum / 10;
            node.next = new ListNode(thisNum);
            node = node.next;
        }
        //防止数字相加完成最后余1进位
        if (nextNum != 0){
            node.next = new ListNode(nextNum);
        }
        return result;
    }

    //V2.0
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //将当前节点初始化为哑结点
        ListNode result = new ListNode(0);
        ListNode p1 = l1,p2 = l2,current = result;
        //初始化进位
        int carray = 0;
        while (null != p1 || null != p2){
            int x = p1 == null ? 0 : p1.val;
            int y = p2 == null ? 0 : p2.val;
            int sum = x + y + carray;
            current.next = new ListNode(sum % 10);
            carray = sum / 10;
            current = current.next;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }
        //最后校验进位
        if (carray != 0)
            current.next = new ListNode(carray);
        return result.next;
    }

}


