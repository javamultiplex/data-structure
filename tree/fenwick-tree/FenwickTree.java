package binaryindextree;

public class FenwickTree {

	private int arr[];
	private int N;
	private int tree[];

	public FenwickTree(int[] arr) {
		this.arr = arr;
		N = arr.length;
		tree = new int[N + 1];
	}

	// O(Nlog(N))
	public void buildTree() {

		for (int i = 0; i < N; i++) {
			updateTree(i, arr[i]);
		}
	}

	// O(log(N))
	public void updateTree(int index, int value) {

		index = index + 1;
		while (index <= N) {
			tree[index] += value;
			index = getNext(index);
		}
	}

	// O(log(N))
	public int getSum(int index) {

		index = index + 1;
		int sum = 0;
		while (index > 0) {
			sum += tree[index];
			index = getParent(index);
		}
		return sum;

	}

	/*
	 * 
	 * 1. Find 2's complement of index. 2. And step 1 result with original
	 * index. 3. Subtract step2 result from original index.
	 */
	// O(1)
	public int getParent(int index) {
		return index - (index & -index);
	}

	/*
	 * 
	 * 1. Find 2's complement of index. 2. And step 1 result with original
	 * index. 3. Add step2 result in original index.
	 */
	// O(1)
	public int getNext(int index) {
		return index + (index & -index);
	}

	public void displayArray() {
		for (int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public void displayTree() {
		for (int i = 1; i <= N; i++) {
			System.out.print(tree[i] + " ");
		}
	}

}
