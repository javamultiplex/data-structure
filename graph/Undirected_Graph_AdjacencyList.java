package com.javamultiplex.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Space complexity is O(V+E)
public class Undirected_Graph_AdjacencyList {

	private Map<Integer,List<Integer>> map;
	public Undirected_Graph_AdjacencyList(int N){
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
		
		if(map.containsKey(b)){
			List<Integer> myList=map.get(b);
			myList.add(a);
			map.put(b,myList);
		}else{
			List<Integer> list=new ArrayList<>();
			list.add(a);
			map.put(b, list);
		}
		
	}
	public boolean isConnected(int a, int b) {
		boolean result=false;
		
		if(map.get(a).contains(b) && map.get(b).contains(a)){
			result=true;
		}
		
		return result;
	}
	
}
