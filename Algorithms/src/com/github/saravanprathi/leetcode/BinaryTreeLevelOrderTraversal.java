package com.github.saravanprathi.leetcode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        TreeNode p;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> ll=new ArrayList<>();
            for(int i=0;i<size;i++){
                p=q.poll();
                ll.add(p.val);
                if(p.left!=null){q.add(p.left);}
                if(p.right!=null){q.add(p.right);}
            }
            result.add(ll);
        }
        return result;
    }
}
