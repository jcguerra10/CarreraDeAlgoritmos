package model;

import java.util.ArrayList;
import java.util.Stack;

import Threads.ABBThread;
import Threads.ArrThread;
import Threads.ListThread;
import application.ControllerGUI;
import javafx.application.Platform;

public class Controller {
	private ArrayList<Double> dataArr;
	private ArrayList<DataArr> arr;;
	private DataList firstDataList;
	private DataTree parentDataTree;
	
	private ControllerGUI cgui;
	
	private Times times;

	public Controller() {
		arr = new ArrayList<DataArr>();
		dataArr = new ArrayList<Double>();
		times = new Times();
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

	public ArrayList<Double> getDataArr() {
		return dataArr;
	}

	public void setDataArr(ArrayList<Double> dataArr) {
		this.dataArr = dataArr;
	}

	public Times getTimes() {
		return times;
	}

	public void setTimes(Times times) {
		this.times = times;
	}	

	public ControllerGUI getCgui() {
		return cgui;
	}

	public void setCgui(ControllerGUI cgui) {
		this.cgui = cgui;
	}

	public ArrayList<Double> generateNumbers(Long number) {
		double pos;
		long nCartas = number;

		ArrayList<Double> pCartas = new ArrayList<Double>();

		for (int i = 0; i < nCartas; i++) {
			pos = (Math.random() * nCartas);
			pCartas.add(pos);
		}
		dataArr = pCartas;
		return pCartas;
	}

	// ----------------methods add----------------//

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

	// ----------------methods search----------------//

	public boolean searchArrayIterative(double search) {
		boolean exist = false;
		for (int i = 0; i < arr.size() && !exist; i++) {
			if (arr.get(i).getId() == search) {
				exist = true;
			}
		}
		return exist;
	}

	public boolean searchArrayRecursive(int i, double search) {
		boolean exist = false;
		if (arr.size() < i) {
			if (arr.get(i).getId() == search) {
				exist = true;
			} else {
				exist = searchArrayRecursive(i + 1, search);
			}

		}
		return exist;
	}

	public boolean searchListIterative(double search) {
		boolean exist = false;
		DataList temp = firstDataList;
		while (temp != null && !exist) {
			if (temp.getId() == search) {
				exist = true;
			}
			temp = temp.getNext();
		}
		return exist;
	}

	public boolean searchListRecursive(DataList temp, double search) {
		boolean exist = false;
		if (temp != null) {
			if (temp.getId() == search) {
				exist = true;
			} else {
				exist = searchListRecursive(temp.getNext(), search);
			}
		}
		return exist;
	}

	public boolean searchTreeIterative(double search) {
		boolean exist = false;
		boolean e = false;
		DataTree temp = parentDataTree;
		while (temp != null && !e) {
			if (search > temp.getId()) {
				if (temp.getRight() == null) {
					e = true;
				} else {
					temp = temp.getRight();
				}
			} else if (search < temp.getId()) {
				if (temp.getLeft() == null) {
					e = true;
				} else {
					temp = temp.getLeft();
				}
			} else {
				exist = true;
				e = true;
			}
		}
		return exist;
	}

	public boolean searchTreeRecursive(DataTree temp, double search) {
		boolean exist = false;
		if (search > temp.getId()) {
			if (temp.getRight() == null) {
				exist = false;
			} else {
				exist = searchTreeRecursive(temp.getRight(), search);
			}
		} else if (search < temp.getId()) {
			if (temp.getLeft() == null) {
				exist = false;
			} else {
				exist = searchTreeRecursive(temp.getLeft(), search);
			}
		} else {
			exist = true;
		}

		return exist;
	}

	// ----------------methods delete----------------//

	public boolean deleteArrayIterative(double search) {
		boolean exist = false;
		for (int i = 0; i < arr.size() && !exist; i++) {
			if (arr.get(i).getId() == search) {
				arr.remove(i);
				exist = true;
			}
		}
		return exist;
	}

	public boolean deleteArrayRecursive(int i, double search) {
		boolean exist = false;
		if (i < arr.size()) {
			if (exist) {
				if (arr.get(i).getId() == search) {
					arr.remove(i);
					exist = true;
				} else {
					exist = deleteArrayRecursive(i + 1, search);
				}
			}
		}
		return exist;
	}

	public boolean deleteListIterative(double search) {
		boolean exist = false;
		DataList temp = firstDataList;
		while (temp != null && !exist) {
			if (temp.getId() == search) {
				if (temp.getPrev() == null) {
					firstDataList = temp.getNext();
					temp.setPrev(null);
				} else {
					DataList prev = temp.getPrev();
					DataList next = temp.getNext();
					prev.setNext(next);
					if (next != null) {
						next.setPrev(prev);
					}
				}
				exist = true;
			}
			temp = temp.getNext();
		}
		return exist;
	}

	public boolean deleteListRecursive(DataList temp, double search) {
		boolean exist = false;
		if (temp != null) {
			if (temp.getId() == search) {
				if (temp.getPrev() == null) {
					firstDataList = temp.getNext();
				} else {
					DataList prev = temp.getPrev();
					DataList next = temp.getNext();
					prev.setNext(next);
					if (next != null) {
						next.setPrev(prev);
					}
				}
				exist = true;
			} else {
				exist = deleteListRecursive(temp.getNext(), search);
			}
		}
		return exist;
	}

	// ----------------priority methods----------------//

	public void allMethods(long n, int type, int mode) throws InterruptedException {
		double[] allTimes = new double[3];

		generateNumbers(n);

		ArrThread arr = new ArrThread(this, type, mode);
		ListThread list = new ListThread(this, type, mode);
		ABBThread abb = new ABBThread(this, type, mode);

		arr.start();
		list.start();
		abb.start();

	}

	public void updaterArray() {
		cgui.changeLabelArray(Times.secondsArray);
	}

	public void updaterList() {		
		cgui.changeLabelList(Times.secondsList);
	}
	
	public void updaterABB() {
		cgui.changeLabelABB(Times.secondsABB);
	}
}
