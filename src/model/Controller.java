package model;

import java.util.ArrayList;

public class Controller {
	private ArrayList<DataArr> arr;;
	private DataList firstDataList;
	private DataTree parentDataTree;

	public Controller() {

		arr = new ArrayList<DataArr>();
	}

	public ArrayList<DataArr> getArr() {
		return arr;
	}

	public void setArr(ArrayList<DataArr> arr) {
		this.arr = arr;
	}

	public DataList getFirstDataList() {
		return firstDataList;
	}

	public void setFirstDataList(DataList firstDataList) {
		this.firstDataList = firstDataList;
	}

	public DataTree getParentDataTree() {
		return parentDataTree;
	}

	public void setParentDataTree(DataTree parentDataTree) {
		this.parentDataTree = parentDataTree;
	}
	
	//----------------methods add----------------//

	public void addArr(DataArr newdata) {
		arr.add(newdata);
	}

	public void addListIterative(DataList newdata) {
		if (firstDataList == null) {
			firstDataList = newdata;
		} else {
			DataList temp = firstDataList;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(newdata);
			newdata.setPrev(temp);
		}
	}

	public void addListRecursive(DataList temp, DataList newdata) {
		if (firstDataList == null) {
			firstDataList = newdata;
		} else {
			if (temp.getNext() != null) {
				addListRecursive(temp.getNext(), newdata);
			} else {
				temp.setNext(newdata);
			}
		}
	}

	public void addOnTreeIterative(DataTree newdata) {
		if (parentDataTree == null) {
			parentDataTree = newdata;
		} else {
			DataTree temp = parentDataTree;
			boolean e = false;
			while (!e) {
				if (newdata.getId() > temp.getId()) {
					if (temp.getRight() == null) {
						temp.setRight(newdata);
						e = true;
					} else {
						temp = temp.getRight();
					}
				} else {
					if (temp.getLeft() == null) {
						temp.setLeft(newdata);
						e = true;
					} else {
						temp = temp.getLeft();
					}
				}
			}
		}
	}

	public void addOnTreeRecursive(DataTree temp, DataTree newdata) {
		if (parentDataTree == null) {
			parentDataTree = newdata;
		} else {
			if (newdata.getId() > temp.getId()) {
				if (temp.getRight() == null) {
					temp.setRight(newdata);
				} else {
					addOnTreeRecursive(temp.getRight(), newdata);				
				}
			} else {
				if (temp.getLeft() == null) {
					temp.setLeft(newdata);					
				} else {
					addOnTreeRecursive(temp.getLeft(), newdata);
				}
			}
		}
	}
	
	//----------------methods search----------------//
	
	public boolean searchArrayIterative(int search) {
		boolean exist = false;
		for (int i = 0; i < arr.size() && !exist; i++) {
			if (arr.get(i).getId() == search) {
				exist = true;
			}
		}
		return exist;
	}
	
	public boolean searchArrayRecursive(int i, int search) {
		boolean exist = false;
		if (arr.size() < i) {
			if (arr.get(i).getId() == search) {
				exist = true;
			}else {
				exist = searchArrayRecursive(i+1, search);
			}
			
		}
		return exist;
	}
	
	public boolean searchListIterative(int search) {
		boolean exist = false;
		DataList temp = firstDataList;
		while (temp != null && !exist) {
			if (temp.getId() == search) {
				exist = true;
			}
		}
		return exist;
	}
	
	public boolean searchListRecursive(DataList temp, int search) {
		boolean exist = false;
		if (temp != null) {
			if (temp.getId() == search) {
				exist = true;
			}else {
				exist = searchListRecursive(temp.getNext(), search);
			}
		}
		return exist;
	}
	
	public boolean searchTreeIterative(int search) {
		boolean exist = false;
		boolean e = false;
		DataTree temp = parentDataTree;
		while (temp != null && !e) {
			if (search > temp.getId()) {
				if (temp.getRight() == null) {
					e = true;
				}else {
					temp = temp.getRight();
				}
			} else if (search < temp.getId()) {
				if (temp.getLeft() == null) {
					e = true;
				}else {
					temp = temp.getLeft();
				}
			} else {
				exist = true;
				e = true;
			}
		}
		return exist;
	}
	
	public boolean searchTreeRecursive(DataTree temp, int search) {
		boolean exist = false;
		if (search > temp.getId()) {
			if (temp.getRight() == null) {
				exist = false;
			}else {
				exist = searchTreeRecursive(temp.getRight(), search);
			}
		} else if (search < temp.getId()) {
			if (temp.getLeft() == null) {
				exist = false;
			}else {
				exist = searchTreeRecursive(temp.getLeft(), search);
			}
		} else {
			exist = true;
		}
		
		return exist;
	}
	
}
