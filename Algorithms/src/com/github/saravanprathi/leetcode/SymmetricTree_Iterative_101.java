package com.github.saravanprathi.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SymmetricTree_Iterative_101 {
    public boolean isSymmetric(TreeNode root) {
    	if(root==null){
            return true;
        }
    	Queue<TreeNode> q=new LinkedList<>();
    	q.add(root.left);
    	q.add(root.right);
    	while(!q.isEmpty()) {
    		TreeNode left=q.poll();
    		TreeNode right=q.poll();
    		if(left==null && right==null) 
    			continue;
    		
    		if(left==null || right==null) 
    			return false;
    		if(left.val!=right.val)
    			return false;
    		q.add(left.right);
    		q.add(right.left);
    		q.add(left.left);
    		q.add(right.right);			
    	}
    return true;	
    }
}