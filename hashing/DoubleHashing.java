package com.javamultiplex.datastructure.hashing;

//Double Hashing.
public class DoubleHashing {

	private int table[];
	private int tableSize;

	public DoubleHashing(int N) {
		setTable(new int[N]);
		this.tableSize = N;
	}

	public void insert(int key) {

		int i = 0;
		int index = hash(key, i);
		int original = index;
		while (getTable()[index] != 0) {
			i = i + 1;
			index = hash(key, i);
			if (index == original) {
				System.out.println("Hash table is full, not able to insert " + key);
				return;
			}
		}
		getTable()[index] = key;
	}

	public int search(int key) {

		int i = 0;
		int index = hash(key, i);
		int original = index;
		while (table[index] != key) {
			i = i + 1;
			index = hash(key, i);
			if (table[index] == 0 || original == index) {
				return -1;
			}
		}

		return index;
	}

	public void delete(int key) {

		int index = search(key);
		if (index != -1) {
			table[index] = 0;
			System.out.println("Key has been deleted successfully.");
		} else {
			System.out.println("Key not found.");
		}
	}

	private int hash(int key, int i) {

		int index = (key + i * hash2(key)) % tableSize;
		return index;
	}

	private int hash2(int key) {
		return 5 - key % 5;
	}

	public int[] getTable() {
		return table;
	}

	public void setTable(int table[]) {
		this.table = table;
	}

}
