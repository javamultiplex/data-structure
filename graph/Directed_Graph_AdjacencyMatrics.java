package com.javamultiplex.datastructure.graph;

import java.util.Arrays;

//Space complexity is O(V^2)
public class Directed_Graph_AdjacencyMatrics {

	private int[][] graph;

	public Directed_Graph_AdjacencyMatrics(int N) {
		graph = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(graph[i], 0);
		}
	}

	public void addEdge(int a, int b) {

		graph[a-1][b-1]=1;
		
	}

	public boolean isConnected(int a, int b) {
		
		boolean result=false;
		if(graph[a-1][b-1]==1){
			result=true;
		}
		return result;
	}

}
