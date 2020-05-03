package model;

public class DataTree {
	private int id;

	private DataTree right;
	private DataTree left;

	public DataTree(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
