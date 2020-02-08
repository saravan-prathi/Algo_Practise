package com.github.saravanprathi.leetcode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BinaryTreePostOrderTraversal_Iterative {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> a=new ArrayList();
        postorderTraversal(root,a);
        return a;
    }
    public void postorderTraversal(TreeNode n,ArrayList<Integer> a){
        if(n==null){
            return;
        }
        Stack<TreeNode> s1=new Stack<TreeNode>();
        Stack<TreeNode> s2=new Stack<TreeNode>();
        s1.push(n);
        while(!s1.isEmpty()){
            n=s1.pop();
            s2.push(n);
            if(n.left!=null){s1.push(n.left);}
            if(n.right!=null){s1.push(n.right);}
        }
    while(!s2.isEmpty()){
        a.add(s2.pop().val);
    }   
    }
}