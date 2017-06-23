package com.javamultiplex.datastructure.tree.segmenttree;

public class SegmentTree {

	private int arr[];
	private int N;
	private int tree[];
	private int size;

	public SegmentTree(int[] arr) {
		N = arr.length;
		this.arr = arr;
		int x = (int) Math.ceil(Math.log(N) / Math.log(2));
		size = (int) (2 * Math.pow(2, x) - 1);
		tree = new int[size];
	}

	// O(N)
	public void build() {

		int node = 0;
		int start = 0;
		int end = N - 1;

		build(node, start, end);

	}

	/*
	 * 
	 * Each node of Segment Tree is storing sum of all the element
	 * in range. For example [1:3] = arr[1]+arr[2]+arr[3]
	 * 
	 */
	private void build(int node, int start, int end) {

		if (start == end) {
			tree[node] = arr[start];
		} else {
			int mid = (start + end) / 2;
			build(leftChild(node), start, mid);
			build(rightChild(node), mid + 1, end);
			tree[node] = tree[leftChild(node)] + tree[rightChild(node)];
		}

	}

	//O(log(N))
	public void update(int index, int value) {
		int node = 0;
		int start = 0;
		int end = N - 1;
		update(node, start, end, index, value);
	}

	private void update(int node, int start, int end, int index, int value) {

		if (start == end) {
			arr[index] = value;
			tree[node] = value;
		} else {
			int mid = (start + end) / 2;
			if (start <= index && index <= mid) {
				update(leftChild(node), start, mid, index, value);
			} else {
				update(rightChild(node), mid + 1, end, index, value);
			}
			tree[node] = tree[leftChild(node)] + tree[rightChild(node)];
		}

	}

	//O(log(N))
	public int rangeSumQuery(int l,int r){
		int node = 0;
		int start = 0;
		int end = N - 1;
		return rangeSumQuery(node,start,end,l,r);
	}
	
	private int rangeSumQuery(int node, int start, int end, int l, int r) {
		
		//Outside Range.
		if(end<l || start>r){
			return 0;
		}
		//Complete Range.
		else if(l<=start && end<=r){
			return tree[node];
		}
		//Partial Range
		else{
			int mid=(start+end)/2;
			int p1=rangeSumQuery(leftChild(node),start,mid,l,r);
			int p2=rangeSumQuery(rightChild(node),mid+1,end,l,r);
			return p1+p2;
		}
	}

	public int size() {
		return size;
	}

	public int leftChild(int i) {
		return 2 * i + 1;
	}

	public int rightChild(int i) {
		return 2 * i + 2;
	}

	public int parent(int i) {
		return (i - 1) / 2;
	}

	public void displayTree() {
		for (int i = 0; i < size; i++) {
			System.out.print(tree[i] + " ");
		}
	}

	public void displayArray() {
		for (int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
