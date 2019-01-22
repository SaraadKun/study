package com.leetcode.code.binarytree;

import com.leetcode.model.BinaryTreeNode;

/**
 * All rights Reserved, Designed By SARAAD
 *
 * @version V1.0
 * @Title: GetNextNode
 * @Package:com.leetcode.code.binarytree
 * @Description: 查找中序遍历二叉树的下一个节点
 * @author: saraad
 * @date: 2019/1/22 23:56
 * @Copyright: 2019  Inc. All rights reserved.
 * PROJECT FOR PRACTICE
 */
public class GetNextNode {

    public static void main(String[] args){
        BinaryTreeNode node = getData();
        BinaryTreeNode next = getNext(node);
        System.out.println(next);

    }

    private static BinaryTreeNode getNext(BinaryTreeNode node){
        //边界条件判断
        if(null == node)
            return null;
        BinaryTreeNode nextNode = null;
        //若node有右子树,则右子树的最后一个不为null的左节点即为nextNode
        if (null != node.right){
            nextNode = node.right;
            while (null != nextNode.left)
                nextNode = nextNode.left;
        }else if (null != node.parent){
            BinaryTreeNode current = node;
            nextNode = node.parent;
            while (null != current.parent && nextNode.right == current){
                current = nextNode;
                nextNode = current.parent;
            }
        }
        return nextNode;
    }

    private static BinaryTreeNode getData(){
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode firstRL = new BinaryTreeNode(2,root,null,null);
        BinaryTreeNode secondRLL = new BinaryTreeNode(4,firstRL,null,null);
        BinaryTreeNode secondRLR = new BinaryTreeNode(5,firstRL,null,null);
        BinaryTreeNode thirdRLRL = new BinaryTreeNode(8,secondRLR,null,null);
        BinaryTreeNode thirdRLRR = new BinaryTreeNode(9,secondRLR,null,null);
        secondRLR.left = thirdRLRL;
        secondRLR.right = thirdRLRR;
        firstRL.left = secondRLL;
        firstRL.right = secondRLR;
        BinaryTreeNode firstRR = new BinaryTreeNode(3,root,null,null);
        BinaryTreeNode secondRRL = new BinaryTreeNode(6,firstRR,null,null);
        BinaryTreeNode secondRRR = new BinaryTreeNode(7,firstRR,null,null);
        firstRR.left = secondRRL;
        firstRR.right = secondRRR;
        root.left = firstRL;
        root.right = firstRR;
//        return root;
//        return secondRLL;
//        return thirdRLRL;
//        return thirdRLRR;
        return  secondRRR;
    }

}
