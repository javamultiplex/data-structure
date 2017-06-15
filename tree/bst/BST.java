package com.javamultiplex.datastructure.tree;

public class BST {

	private class Node {

		private int data;
		private Node left;
		private Node right;

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
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

	}

	private Node root;

	public void insert(int data) {

		root = insert(root, data);

	}

	public void delete(int data) {
		root = delete(root, data);
	}

	private Node delete(Node node, int data) {

		if (node == null) {
			return node;
		} else if (data < node.getData()) {
			node.setLeft(delete(node.getLeft(), data));
		} else if (data > node.getData()) {
			node.setRight(delete(node.getRight(), data));
		} else {

			if (node.getLeft() == null && node.getRight() == null) {
				node = null;
			}else if (node.getLeft() == null) {
				node = node.getRight();
			} else if (node.getRight() == null) {
				node = node.getLeft();
			} else {
				Node temp = findMin(node.getRight());
				node.setData(temp.getData());
				node.setRight(delete(node.getRight(), temp.getData()));
			}

		}
		return node;

	}

	private Node findMin(Node node) {

		while (node.getLeft() != null) {
			node = node.getLeft();
		}

		return node;
	}

	private Node insert(Node node, int data) {

		if (node == null) {
			node = new Node(data);
		} else {
			Node head = node;
			if (data <= head.getData()) {
				head.setLeft(insert(head.getLeft(), data));
			} else if (head.getData() < data) {
				head.setRight(insert(head.getRight(), data));
			}

		}
		return node;
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

	public Node findNode(int data) {
		return findNode(root, data);
	}

	private Node findNode(Node head, int data) {

		if (head.getData() == data) {
			return head;
		} else if (head.getData() >= data) {
			return findNode(head.getLeft(), data);
		} else if (head.getData() < data) {
			return findNode(head.getRight(), data);
		}
		return null;
	}

}
