package com.javamultiplex.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Space complexity is O(V+E)
public class Directed_Graph_AdjacencyList {

	private Map<Integer,List<Integer>> map;
	public Directed_Graph_AdjacencyList(int N){
		map=new HashMap<Integer, List<Integer>>(N);
	}
	public void addEdge(int a, int b) {
	
		if(map.containsKey(a)){
			List<Integer> myList=map.get(a);
			myList.add(b);
			map.put(a,myList);
		}else{
			List<Integer> list=new ArrayList<>();
			list.add(b);
			map.put(a, list);
		}
		
		
	}
	public boolean isConnected(int a, int b) {
		boolean result=false;
		
		if(map.get(a).contains(b)){
			result=true;
		}
		
		return result;
	}
	
}
