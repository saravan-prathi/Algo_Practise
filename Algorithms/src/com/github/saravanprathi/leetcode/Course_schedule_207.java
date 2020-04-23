package com.github.saravanprathi.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Course_schedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
     Map<Integer,List<Integer>> graph=new HashMap();
     for(int[] edge:prerequisites){
         int start=edge[1],end=edge[0];
         if(!graph.containsKey(start))
        	 graph.put(start,new ArrayList());
         graph.get(start).add(end);
     } 
     
     Set<Integer> whiteSet=new HashSet();
     Set<Integer> greySet=new HashSet();
     Set<Integer> blackSet=new HashSet();
     for(int i=0;i<numCourses;i++) {
    	whiteSet.add(i);
     }
     while(whiteSet.size()>0) { 
    	 if(dfs(whiteSet.iterator().next(),whiteSet,greySet,blackSet,graph))
    		return false;
     }
     return true;
    }

	private boolean dfs(int i, Set<Integer> whiteSet, Set<Integer> greySet, Set<Integer> blackSet,Map<Integer,List<Integer>> graph) {
		// TODO Auto-generated method stub
		moveSet(i,whiteSet,greySet);
		if(graph.get(i)!=null) {
		for(int j:graph.get(i)) {
			if(blackSet.contains(j))
				continue;
			if(greySet.contains(j))
				return true;
			if(dfs(j,whiteSet,greySet,blackSet,graph))
				return true;
		}
		}
		moveSet(i,greySet,blackSet);
		return false;
	}

	private void moveSet(int i, Set<Integer> fromSet, Set<Integer> toSet) {
		// TODO Auto-generated method stub
		if(fromSet.remove(i))
			toSet.add(i);
	}
}