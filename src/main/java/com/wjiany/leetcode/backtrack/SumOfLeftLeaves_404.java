package com.wjiany.leetcode.backtrack;

import com.wjiany.leetcode.tree.TreeNode;
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
public class SumOfLeftLeaves_404 {

    @Test
    public void test(){
        TreeNode root = new TreeNode(9);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.left.left = new TreeNode(-7);
        root.right.left.left.left = new TreeNode(-1);

        System.out.println(sumOfLeftLeaves(root));
    }


    int max = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return max;
       
       rec(root,false);
       return max;
        
    }

    public void rec(TreeNode n,boolean left){ 
           if(n.left == null && n.right == null && left){
            max += n.val;
            return;
           }
           if(n.left != null){
            rec(n.left,true);
           }
            if(n.right != null){
            rec(n.right,false);
           }
    }
}