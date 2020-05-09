package model;

public class DataList {
	private double id;

	private DataList next;
	private DataList prev;

	public DataList(double id) {
		this.id = id;
	}

	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	public DataList getNext() {
		return next;
	}

	public void setNext(DataList next) {
		this.next = next;
	}

	public DataList getPrev() {
		return prev;
	}

	public void setPrev(DataList prev) {
		this.prev = prev;
	}

}
