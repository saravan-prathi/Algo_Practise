package com.github.saravanprathi.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort<T> {
	private Stack<Vertex<T>> topSort(Graph<T> graph){
		Stack<Vertex<T>> stack=new Stack<>();
		Set<Vertex<T>> visited=new HashSet<>();
		for(Vertex<T> v: graph.getAllVertex()) {
			if(visited.contains(v))
				continue;
			topSortUtil(v,stack,visited);
		}
		return stack;
	}
	
	

	private void topSortUtil(Vertex<T> v, Stack<Vertex<T>> stack, Set<Vertex<T>> visited) {
		// TODO Auto-generated method stub
		visited.add(v);
		for(Vertex<T> child:v.getAdjacentVertexes()) {
			if(visited.contains(child))
				continue;
			
			topSortUtil(child,stack,visited);
		}
		stack.push(v);
	}


	public static void main(String[] args) {
		Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 8);
        graph.addEdge(8, 11);
        TopologicalSort<Integer> t=new TopologicalSort<>();
        Stack<Vertex<Integer>> result=t.topSort(graph);
        while(!result.isEmpty()) {
        	System.out.println(result.pop());
        }
        
	}
}
