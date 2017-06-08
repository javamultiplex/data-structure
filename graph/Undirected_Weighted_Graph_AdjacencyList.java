package com.javamultiplex.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Space complexity is O(V+E)
public class Undirected_Weighted_Graph_AdjacencyList {

	public class Edge {
		int node;
		int weight;

		public Edge(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}
	}

	private Map<Integer, List<Edge>> map;

	public Undirected_Weighted_Graph_AdjacencyList(int N) {
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

		if (map.containsKey(b)) {
			List<Edge> myList = map.get(b);
			edge = new Edge(a, weight);
			myList.add(edge);
			map.put(b, myList);
		} else {
			List<Edge> list = new ArrayList<>();
			edge = new Edge(a, weight);
			list.add(edge);
			map.put(b, list);
		}

	}

	public boolean isConnected(int a, int b) {
		boolean result1 = false;
		boolean result2 = false;
		List<Edge> list=map.get(a);
		int size=list.size();
		Edge edge=null;
		for(int i=0;i<size;i++){
			edge=list.get(i);
			if(edge.node==b){
				result1=true;
				break;
			}
		}
		
		list=map.get(b);
		size=list.size();
		edge=null;
		for(int i=0;i<size;i++){
			edge=list.get(i);
			if(edge.node==a){
				result2=true;
				break;
			}
		}
		
		return result1&&result2;
	}

}
