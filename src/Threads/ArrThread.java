package Threads;

import java.util.ArrayList;

import model.Controller;
import model.DataArr;
import model.DataList;
import model.DataTree;
import model.Times;

public class ArrThread extends Thread {

	private Controller c;

	private Times times;
	private int type;
	private int mode;

	public ArrThread(Controller c, int type, int mode) {
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
			try {
				addArray();
			} catch (InterruptedException e) {
				
			}
			break;
		case 2:
			if (mode == 1) {
				try {
					searchArrayIterative();
				} catch (InterruptedException e) {

				}
			} else {
				try {
					searchArrayRecursive();
				} catch (InterruptedException e) {

				}
			}
			break;
		case 3:
			if (mode == 1) {
				try {
					eliminateArrayIterative();
				} catch (InterruptedException e) {
								
				}
			} else {
				try {
					eliminateArrayRecursive();
				} catch (InterruptedException e) {

				}
			}
		default:
			break;
		}
		c.updaterArray();
	}

	public void addArray() throws InterruptedException {
		ArrayList<Double> arrget = c.getDataArr();
		Long l = System.currentTimeMillis();
		for (int i = 0; i < arrget.size(); i++) {
			c.addArr(new DataArr(arrget.get(i)));
			Thread.sleep(100);
		}
		Long l1 = System.currentTimeMillis();
		Times.secondsArray = l1 - l;
	}

	public void searchArrayIterative() throws InterruptedException {
		ArrayList<Double> arrget = c.getDataArr();
		Long l = System.currentTimeMillis();
		for (int i = 0; i < arrget.size(); i++) {
			c.searchArrayIterative(arrget.get(i));
			Thread.sleep(100);
		}
		Long l1 = System.currentTimeMillis();
		Times.secondsArray = l1 - l;
	}

	public void searchArrayRecursive() throws InterruptedException {
		ArrayList<Double> arrget = c.getDataArr();
		Long l = System.currentTimeMillis();
		for (int i = 0; i < arrget.size(); i++) {
			c.searchArrayRecursive(0, arrget.get(i));
			Thread.sleep(100);
		}
		Long l1 = System.currentTimeMillis();
		Times.secondsArray = l1 - l;
	}

	public void eliminateArrayIterative() throws InterruptedException {
		ArrayList<Double> arrget = c.getDataArr();
		Long l = System.currentTimeMillis();
		for (int i = 0; i < arrget.size(); i++) {
			c.deleteArrayIterative(arrget.get(i));
			Thread.sleep(100);
		}
		Long l1 = System.currentTimeMillis();
		Times.secondsArray = l1 - l;
	}

	public void eliminateArrayRecursive() throws InterruptedException {
		ArrayList<Double> arrget = c.getDataArr();
		Long l = System.currentTimeMillis();
		for (int i = 0; i < arrget.size(); i++) {
			c.deleteArrayRecursive(0, arrget.get(i));
			Thread.sleep(100);
		}
		Long l1 = System.currentTimeMillis();
		Times.secondsArray = l1 - l;
	}

}
