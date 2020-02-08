package com.github.saravanprathi.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
class BinaryTreePreOrderTraversal_Iterative {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> a=new ArrayList<Integer>();
        preorderTraversal(root,a);
        return a;
    }
    
    public void preorderTraversal(TreeNode n,ArrayList<Integer> a){
        if(n==null){
            return;
        }
        Stack<TreeNode> s=new Stack<TreeNode>();
        s.push(n);
        while(!s.isEmpty()){
            n=s.pop();
            a.add(n.val);
            if(n.right!=null){
                s.push(n.right);
            }
            if(n.left!=null){
                s.push(n.left);
            }
        }
        return;
    }
}