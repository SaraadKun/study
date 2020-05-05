package com.leetcode.code.binarytree;

import com.leetcode.model.BinaryTreeNode;

/**
 * All rights Reserved, Designed By SARAAD
 *
 * @version V1.0
 * @Title: ReBuildBinaryTree
 * @Package:com.leetcode.code
 * @Description: 输入二叉树的前序遍历和中序遍历结果,重建二叉树
 * @author: saraad
 * @date: 2019/1/14 0:34
 * @Copyright: 2019  Inc. All rights reserved.
 * PROJECT FOR PRACTICE
 */
public class ReBuildBinaryTree {

    public static void main(String[] args){
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] mid = {4,7,2,1,5,3,8,6};
//        int[] mid = {4,7,1,2,5,3,8,6};
        BinaryTreeNode tree = reBuild(pre,mid);
        System.out.println("end");

    }

    private static BinaryTreeNode reBuild(int[] pre, int[] in) {
        //边界条件
        if(null == pre || null == in || 0 == pre.length || 0 == in.length || pre.length != in.length){
            return null;
        }
        BinaryTreeNode node = new BinaryTreeNode();
        return build(pre,0,pre.length-1,in,0,in.length-1);
    }

    //入参,两个数组,pre startIndex endIndex, in startIndex  endIndex
    private static BinaryTreeNode build(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd){
        BinaryTreeNode node = new BinaryTreeNode();
        //边界条件 叶子节点
        if (preStart == preEnd){
            if (inStart == inEnd && pre[preStart] == in[inStart]) {
                node.value = pre[preStart];
                node.left = null;
                node.right = null;
                return node;
            }else {
                throw new RuntimeException("invalid input");//非法输入
            }
        }
        node.value = pre[preStart];
        int index = inStart;
        while (index <= inEnd && in[index] != pre[preStart])
            ++index;
        if(index == inEnd && in[index] != pre[preStart]){
            throw new RuntimeException("Invalid input");//非法输入
        }
        int lenth = index - inStart;
        //构建左子树
        if (lenth>0)
            node.left = build(pre, preStart + 1, preStart + lenth, in, inStart, index - 1);
        //构建右子树
        if (lenth<preEnd - preStart)
            node.right = build(pre, preStart + lenth + 1, preEnd, in, index + 1, inEnd);
        return node;
    }

}
