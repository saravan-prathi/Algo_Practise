package com.github.saravanprathi.leetcode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isSymmetric(root.left,root.right);
    }
    public boolean isSymmetric(TreeNode left,TreeNode right){
        if(left==null && right==null){
            return true;
        }
        if(left!=null && right!=null){
        return(left.val==right.val && isSymmetric(left.right,right.left) && isSymmetric(left.left,right.right));
        }
        else{
            return false;
        }
    }
}