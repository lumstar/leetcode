package com.wjiany.leetcode.tree;

import org.junit.Test;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class IsValidBST_98 {

    @Test
    public void  test(){
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(6);
        treeNode.right.left =new TreeNode(3);
        treeNode.right.right =new TreeNode(7);
        System.out.println(isValidBST(treeNode,Integer.MIN_VALUE,Integer.MAX_VALUE));

    }

    /**
     * 错误，错误原因：左子树的所有值小于root val，右子树的所有值大于root val，而不仅是临近的子节点值
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(root.left != null && root.right == null) {
            return root.left.val < root.val && isValidBST(root.left);
        }
        if(root.right != null && root.left == null) {
            return root.right.val > root.val && isValidBST(root.right);
        }
        if(root.right == null && root.left == null) return true;
        return root.left.val < root.val && isValidBST(root.left) && root.right.val > root.val && isValidBST(root.right);

    }
    public boolean isValidBST(TreeNode root,int max, int min) {
        if(root == null) return true;

        if(root.val < min || root.val > max) return false;

        return isValidBST(root.left,max,root.val) && isValidBST(root.right, root.val, min);
    }
}