package com.javamultiplex.datastructure.graph;

import java.util.Arrays;

//Space complexity is O(V^2)
public class Undirected_Weighted_Graph_AdjacencyMatrics {

	private int[][] graph;

	public Undirected_Weighted_Graph_AdjacencyMatrics(int N) {
		graph = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(graph[i], 0);
		}
	}

	public void addEdge(int a, int b,int weight) {

		graph[a-1][b-1]=weight;
		graph[b-1][a-1]=weight;
		
	}

	public boolean isConnected(int a, int b) {
		
		boolean result=false;
		if(graph[a-1][b-1]!=0 && graph[b-1][a-1]!=0){
			result=true;
		}
		return result;
	}

}
