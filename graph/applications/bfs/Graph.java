package com.javamultiplex.datastructure.graph.applications.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Graph {

	private Map<Integer, List<Integer>> graph;
	private Queue<Integer> queue;
	private boolean visited[];
	private int distance[];
	private int level[];
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

	public void bfs(int s) {
		visited = new boolean[nodes];
		level = new int[nodes];
		distance = new int[nodes];
		Arrays.fill(visited, false);
		queue = new LinkedList<>();
		queue.add(s);
		visited[s] = true;
		level[s] = 0;
		distance[s] = 0;
		traversal();
	}

	private void traversal() {

		int element = 0, size = 0, neighbour = 0;
		List<Integer> neighbours = null;
		while (!queue.isEmpty()) {
			element = queue.remove();
			System.out.print(element + "->");
			neighbours = graph.get(element);
			size = neighbours.size();
			for (int i = 0; i < size; i++) {
				neighbour = neighbours.get(i);
				if (!visited[neighbour]) {
					level[neighbour] = level[element] + 1;
					distance[neighbour] = distance[element] + 1;
					queue.add(neighbour);
					visited[neighbour] = true;
				}
			}
		}

	}

	public int getLevel(int node) {
		return level[node];
	}

	public int getDistanceFromSource(int node) {
		return distance[node];
	}

}
