package com.javamultiplex.datastructure.graph.applications.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph01 {

	public class Edge {
		int node;
		int weight;

		public Edge(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}
	}

	private Map<Integer, List<Edge>> graph;
	private Deque<Integer> deque;
	private int distance[];
	private int nodes;

	public Graph01(int N) {
		nodes = N;
		graph = new HashMap<Integer, List<Edge>>(N);
	}

	public void addEdge(int a, int b, int weight) {

		Edge edge = null;
		if (graph.containsKey(a)) {
			List<Edge> myList = graph.get(a);
			edge = new Edge(b, weight);
			myList.add(edge);
			graph.put(a, myList);
		} else {
			List<Edge> list = new ArrayList<>();
			edge = new Edge(b, weight);
			list.add(edge);
			graph.put(a, list);
		}

		if (graph.containsKey(b)) {
			List<Edge> myList = graph.get(b);
			edge = new Edge(a, weight);
			myList.add(edge);
			graph.put(b, myList);
		} else {
			List<Edge> list = new ArrayList<>();
			edge = new Edge(a, weight);
			list.add(edge);
			graph.put(b, list);
		}

	}

	private void bfs01(int s) {
		int max = (int) (Math.pow(2, 31) - 1);
		distance = new int[nodes];
		Arrays.fill(distance, max);
		deque = new LinkedList<>();
		deque.add(s);
		distance[s] = 0;
		traversal();
	}

	private void traversal() {

		int element = 0, size = 0, node = 0, weight = 0;
		Edge neighbour = null;
		List<Edge> neighbours = null;
		while (!deque.isEmpty()) {
			element = deque.remove();
			neighbours = graph.get(element);
			size = neighbours.size();
			for (int i = 0; i < size; i++) {
				neighbour = neighbours.get(i);
				node = neighbour.node;
				weight = neighbour.weight;
				if (distance[node] > distance[element] + weight) {
					distance[node] = distance[element] + weight;
					if (weight == 0) {
						deque.addFirst(node);
					} else if (weight == 1) {
						deque.addLast(node);
					}
				}
			}
		}

	}

	public int getDistanceFromSource(int s, int i) {
		bfs01(s);
		return distance[i];
	}

}
