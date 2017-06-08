package com.javamultiplex.array;

public class BinaryTree {

	private class Node {

		private int data;
		private Node left;
		private Node Right;


		public Node(int data) {
			setData(data);
			setLeft(null);
			setRight(null);
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return Right;
		}

		public void setRight(Node right) {
			Right = right;
		}

	}

	private Node root;

	public void insert(String direction, int data) {
		if (root == null) {
			root = new Node(data);
		} else {
			Node temp = root;
			int length = direction.length();
			for (int i = 0; i < length; i++) {
				if (direction.charAt(i) == 'L') {

					if (i == (length - 1)) {
						if (temp.getLeft() == null) {
							Node newNode = new Node(data);
							temp.setLeft(newNode);
						} else {
							temp = temp.getLeft();
							temp.setData(data);
						}
					} else {

						if (temp.getLeft() == null) {
							Node newNode = new Node(0);
							temp.setLeft(newNode);
							temp = temp.getLeft();
						} else {
							temp = temp.getLeft();
						}

					}
				} else if (direction.charAt(i) == 'R') {

					if (i == (length - 1)) {
						if (temp.getRight() == null) {
							Node newNode = new Node(data);
							temp.setRight(newNode);
						} else {
							temp = temp.getRight();
							temp.setData(data);
						}
					} else {
						if (temp.getRight() == null) {
							Node newNode = new Node(0);
							temp.setRight(newNode);
							temp = temp.getRight();
						} else {
							temp = temp.getRight();
						}
					}
				}
			}

		}
	}

	public void preorder() {

		preorder(root);

	}

	private void preorder(Node node) {

		if (node != null) {
			System.out.print(node.getData() + "->");
			preorder(node.getLeft());
			preorder(node.getRight());
		}

	}

	public void inorder() {

		inorder(root);

	}

	private void inorder(Node node) {
		if (node != null) {
			inorder(node.getLeft());
			System.out.print(node.getData() + "->");
			inorder(node.getRight());
		}

	}

	public void postorder() {
		postorder(root);
	}

	private void postorder(Node node) {
		if (node != null) {
			postorder(node.getLeft());
			postorder(node.getRight());
			System.out.println(node.getData() + "->");
		}

	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
	}

	public int[] diameter() {
		return diameter(root);
	}

	private int[] diameter(Node node) {

		int d[] = { 0, 0 };
		if (node == null) {
			return d;
		} else {

			int[] left = diameter(node.getLeft());
			int[] right = diameter(node.getRight());
			int height = Math.max(left[0], right[0]) + 1;
			int leftDiameter = left[1];
			int rightDiameter = right[1];
			int rootDiameter = left[0] + right[0] + 1;
			int finalDiameter = Math.max(Math.max(leftDiameter, rightDiameter), rootDiameter);
			d[0] = height;
			d[1] = finalDiameter;
			return d;
		}
	}

}
