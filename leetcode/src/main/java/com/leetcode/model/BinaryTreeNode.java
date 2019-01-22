package com.leetcode.model;

/**
 * All rights Reserved, Designed By SARAAD
 *
 * @version V1.0
 * @Title: BinaryTreeNode
 * @Package:com.leetcode.model
 * @Description:
 * @author: saraad
 * @date: 2019/1/14 0:35
 * @Copyright: 2019  Inc. All rights reserved.
 * PROJECT FOR PRACTICE
 */
public class BinaryTreeNode {

    public int value;

    public BinaryTreeNode parent;

    public BinaryTreeNode left;

    public BinaryTreeNode right;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public BinaryTreeNode(int value, BinaryTreeNode parent, BinaryTreeNode left, BinaryTreeNode right) {
        this.value = value;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
}
