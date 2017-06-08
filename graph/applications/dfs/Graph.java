package com.javamultiplex.datastructure.graph.applications.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

	private Map<Integer, List<Integer>> graph;
	private boolean[] visited;
	private int nodes;

	public Graph(int N) {
		nodes = N;
		graph = new HashMap<Integer, List<Integer>>(N);
	}

	public void addEdge(int a, int b) {

		if (graph.containsKey(a)) {
			List<Integer> myList = graph.get(a);
			myList.add(b);
			graph.put(a, myList);
		} else {
			List<Integer> list = new ArrayList<>();
			list.add(b);
			graph.put(a, list);
		}

		if (graph.containsKey(b)) {
			List<Integer> myList = graph.get(b);
			myList.add(a);
			graph.put(b, myList);
		} else {
			List<Integer> list = new ArrayList<>();
			list.add(a);
			graph.put(b, list);
		}

	}

	public void dfs(int s) {

		visited = new boolean[nodes];
		Arrays.fill(visited, false);
		traversal(s);

	}

	private void traversal(int s) {

		visited[s] = true;
		System.out.print(s + " -> ");
		if (graph.containsKey(s)) {
			List<Integer> neighbours = graph.get(s);
			int size = neighbours.size();
			int neighbour = 0;
			for (int i = 0; i < size; i++) {
				neighbour = neighbours.get(i);
				if (!visited[neighbour]) {
					traversal(neighbour);
				}
			}
		}

	}

	public int getCountOfConnectedComponents() {
		int count = 0;
		visited = new boolean[nodes];
		for (int i = 0; i < nodes; i++) {

			if (!visited[i]) {
				traversal(i);
				count++;
			}
		}

		return count;
	}

}
