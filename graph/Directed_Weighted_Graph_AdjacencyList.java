package com.javamultiplex.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Space complexity is O(V+E)
public class Directed_Weighted_Graph_AdjacencyList {

	public class Edge {
		int node;
		int weight;

		public Edge(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}
	}

	private Map<Integer, List<Edge>> map;

	public Directed_Weighted_Graph_AdjacencyList(int N) {
		map = new HashMap<Integer, List<Edge>>(N);
	}

	public void addEdge(int a, int b, int weight) {

		Edge edge = null;
		if (map.containsKey(a)) {
			List<Edge> myList = map.get(a);
			edge = new Edge(b, weight);
			myList.add(edge);
			map.put(a, myList);
		} else {
			List<Edge> list = new ArrayList<>();
			edge = new Edge(b, weight);
			list.add(edge);
			map.put(a, list);
		}

	}

	public boolean isConnected(int a, int b) {
		boolean result = false;
		List<Edge> list=map.get(a);
		int size=list.size();
		Edge edge=null;
		for(int i=0;i<size;i++){
			edge=list.get(i);
			if(edge.node==b){
				result=true;
				break;
			}
		}
		return result;
	}

}
