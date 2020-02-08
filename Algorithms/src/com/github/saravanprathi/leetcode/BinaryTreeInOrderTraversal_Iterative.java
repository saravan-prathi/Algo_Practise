package com.github.saravanprathi.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BinaryTreeInOrderTraversal_Iterative {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> a=new ArrayList<Integer>();
        inorderTraversal(root,a);
        return a;
    }
    public void inorderTraversal(TreeNode n,ArrayList<Integer> a){
        if(n==null){
            return;
        }
        Stack<TreeNode> s=new Stack<TreeNode>();
        while(true){
             if(n!=null){
                 s.push(n);
                 n=n.left;
             }    
            else{
                if(s.isEmpty()){return;}
                n=s.pop();
                a.add(n.val);
                n=n.right;
            }
        }
    }
}
