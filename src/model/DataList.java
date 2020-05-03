package model;

public class DataList {
	private int id;

	private DataList next;
	private DataList prev;

	public DataList(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
