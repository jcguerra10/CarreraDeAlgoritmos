package model;

public class DataTree {
	private double id;

	private DataTree right;
	private DataTree left;

	public DataTree(double id) {
		super();
		this.id = id;
	}

	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	public DataTree getRight() {
		return right;
	}

	public void setRight(DataTree right) {
		this.right = right;
	}

	public DataTree getLeft() {
		return left;
	}

	public void setLeft(DataTree left) {
		this.left = left;
	}

}
