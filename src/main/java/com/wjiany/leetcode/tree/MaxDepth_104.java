package com.wjiany.leetcode.tree;

public class MaxDepth_104 {
    int maxDeep = 0;
    public int maxDepth(TreeNode root) {
        treeDeep(root,0);
        return maxDeep;
    }
    public void treeDeep(TreeNode node,int deepAdd){

        if(node == null){
            maxDeep = Math.max(maxDeep,deepAdd);
            return;
        }
        treeDeep(node.left,deepAdd+1);
        treeDeep(node.right,deepAdd+1);
    }


    public int maxDepth2(TreeNode root) {

        return deep(root,0);
    }
    public int deep(TreeNode root,int deep){
        if(root == null){
            return deep;
        }
        return Math.max(deep(root.left,deep+1),deep(root.right,deep+1));
    }
}
