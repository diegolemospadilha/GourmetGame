package br.com.gourmet.game.model;

import java.io.Serializable;

public class Node implements Serializable {

	private static final long serialVersionUID = 1L;

	private String value;

	private Node left;

	private Node right;

	public Node(String value) {
		super();
		this.value = value;
	}

	public void print(Node n) {
		if(n != null) {
			System.out.println("node " + n.value);
			if (hasLeft()) {
				print(n.left);

			}
			if (hasRight()) {
				print(n.right);
			}
			
		}

	}
	
	public boolean hasLeft() {
		return this.left != null;
	}
	
	public boolean hasRight() {
		return this.right != null;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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
