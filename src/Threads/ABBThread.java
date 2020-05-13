package Threads;

import java.util.ArrayList;

import application.ControllerGUI;
import javafx.application.Platform;
import model.Controller;
import model.DataTree;
import model.Times;

public class ABBThread extends Thread {

	private Controller c;

	private ControllerGUI cgui;
	
	private int type;
	private int mode;
	
	private Times times;

	public ABBThread(Controller c, int type, int mode) {
		super();
		this.c = c;
		this.type = type;
		this.mode = mode;
		times = c.getTimes();
		cgui = c.getCgui();
	}

	@Override
	public void run() {
		switch (type) {
		case 1:
			if (mode == 1) {
				try {
					addABBIterative();
				} catch (InterruptedException e) {

				}
			} else {
				try {
					addABBrecursive();
				} catch (InterruptedException e) {

				}
			}
			break;
		case 2:
			if (mode == 1) {
				try {
					searchABBIterative();
				} catch (InterruptedException e) {

				}
			} else {
				try {
					searchABBRecursive();
				} catch (InterruptedException e) {

				}
			}
			break;
		case 3:
			if (mode == 1) {
				eliminateABBIterative();
			} else {
				eliminateABBRecursive();
			}
		default:
			break;
		}
		
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				cgui.changeLabelABB(Times.secondsABB);
			}
			
		});
	}

	public void addABBIterative() throws InterruptedException {
		ArrayList<Double> arrget = c.getDataArr();
		Long l = System.currentTimeMillis();
		for (int i = 0; i < arrget.size(); i++) {
			c.addOnTreeIterative(new DataTree(arrget.get(i)));
			Thread.sleep(100);
		}
		Long l1 = System.currentTimeMillis();
		Times.secondsABB = (l1 - l)/1000;
		System.out.println(l1-l +" ABB");
	}

	public void addABBrecursive() throws InterruptedException {
		ArrayList<Double> arrget = c.getDataArr();
		Long l = System.currentTimeMillis();
		for (int i = 0; i < arrget.size(); i++) {
			c.addOnTreeRecursive(c.getParentDataTree(), new DataTree(arrget.get(i)));
			Thread.sleep(100);
		}
		Long l1 = System.currentTimeMillis();
		Times.secondsABB = l1 - l/1000;
	}

	public void searchABBIterative() throws InterruptedException {
		ArrayList<Double> arrget = c.getDataArr();
		Long l = System.currentTimeMillis();
		for (int i = 0; i < arrget.size(); i++) {
			c.searchTreeIterative(arrget.get(i));
			Thread.sleep(100);
		}
		Long l1 = System.currentTimeMillis();
		Times.secondsABB = l1 - l/1000;
	}

	public void searchABBRecursive() throws InterruptedException {
		ArrayList<Double> arrget = c.getDataArr();
		Long l = System.currentTimeMillis();
		for (int i = 0; i < arrget.size(); i++) {
			c.searchTreeRecursive(c.getParentDataTree(), arrget.get(i));
			Thread.sleep(100);
		}
		Long l1 = System.currentTimeMillis();
		Times.secondsABB = l1 - l/1000;
	}

	public void eliminateABBIterative() {

	}

	public void eliminateABBRecursive() {

	}
}
