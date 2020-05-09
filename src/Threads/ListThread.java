package Threads;

import java.util.ArrayList;

import model.Controller;
import model.DataList;
import model.Times;

public class ListThread extends Thread {

	private Controller c;

	private int type;
	private int mode;
	
	private Times times;
	
	public ListThread(Controller c, int type, int mode) {
		super();
		this.c = c;
		this.type = type;
		this.mode = mode;
		times = c.getTimes();
	}
	
	@Override
	public void run() {
		switch (type) {
		case 1:
			if (mode == 1) {
				addListIterative();
			}else {
				addListRecursive();
			}
			break;
		case 2:
			if (mode == 1) {
				searchListIterative();
			}else {
				searchListRecursive();
			}
		case 3:
			if (mode == 1) {
				eliminateListIterative();
			}else {
				eliminateListRecursive();
			}
		default:
			break;
		}
		c.updaterList();
	}
	
	public void addListIterative() {
		ArrayList<Double> arrget = c.getDataArr();
		Long l = System.currentTimeMillis();
		for (int i = 0; i < arrget.size(); i++) {
			c.addListIterative((new DataList(arrget.get(i))));
		}
		Long l1 = System.currentTimeMillis();
		Times.secondsArray = l1 - l;
	}
	
	public void addListRecursive() {
		ArrayList<Double> arrget = c.getDataArr();
		Long l = System.currentTimeMillis();
		for (int i = 0; i < arrget.size(); i++) {
			c.addListRecursive(c.getFirstDataList(), new DataList(arrget.get(i)));
		}
		Long l1 = System.currentTimeMillis();
		Times.secondsArray = l1 - l;
	}
	
	public void searchListRecursive() {
		ArrayList<Double> arrget = c.getDataArr();
		Long l = System.currentTimeMillis();
		for (int i = 0; i < arrget.size(); i++) {
			c.searchListIterative(arrget.get(i));
		}
		Long l1 = System.currentTimeMillis();
		Times.secondsArray = l1 - l;
	}
	
	public void searchListIterative() {
		ArrayList<Double> arrget = c.getDataArr();
		Long l = System.currentTimeMillis();
		for (int i = 0; i < arrget.size(); i++) {
			c.searchListRecursive(c.getFirstDataList(), arrget.get(i));
		}
		Long l1 = System.currentTimeMillis();
		Times.secondsArray = l1 - l;
	}
	
	public void eliminateListIterative() {
		ArrayList<Double> arrget = c.getDataArr();
		Long l = System.currentTimeMillis();
		for (int i = 0; i < arrget.size(); i++) {
			c.deleteListIterative(arrget.get(i));
		}
		Long l1 = System.currentTimeMillis();
		Times.secondsArray = l1 - l;
	}
	
	public void eliminateListRecursive() {
		ArrayList<Double> arrget = c.getDataArr();
		Long l = System.currentTimeMillis();
		for (int i = 0; i < arrget.size(); i++) {
			c.deleteListRecursive(c.getFirstDataList(), arrget.get(i));
		}
		Long l1 = System.currentTimeMillis();
		Times.secondsArray = l1 - l;
	}
}
