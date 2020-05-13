package Threads;

import java.util.ArrayList;

import application.ControllerGUI;
import javafx.application.Platform;
import model.Controller;
import model.DataList;
import model.Times;

public class ListThread extends Thread {

	private Controller c;

	private ControllerGUI cgui;
	
	private int type;
	private int mode;
	
	private Times times;
	
	public ListThread(Controller c, int type, int mode) {
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
					addListIterative();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				try {
					addListRecursive();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
		case 2:
			if (mode == 1) {
				try {
					searchListIterative();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				try {
					searchListRecursive();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		case 3:
			if (mode == 1) {
				try {
					eliminateListIterative();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				try {
					eliminateListRecursive();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		default:
			break;
		}
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				cgui.changeLabelList(Times.secondsList);
			}
			
		});
	}
	
	public void addListIterative() throws InterruptedException {
		ArrayList<Double> arrget = c.getDataArr();
		Long l = System.currentTimeMillis();
		for (int i = 0; i < arrget.size(); i++) {
			c.addListIterative((new DataList(arrget.get(i))));
			Thread.sleep(100);
		}
		Long l1 = System.currentTimeMillis();		
		Times.secondsList = (l1 - l)/1000;
		DataList temp = c.getFirstDataList();
		
		System.out.println(l1-l +" list");
		
	}
	
	public void addListRecursive() throws InterruptedException {
		ArrayList<Double> arrget = c.getDataArr();
		Long l = System.currentTimeMillis();
		for (int i = 0; i < arrget.size(); i++) {
			c.addListRecursive(c.getFirstDataList(), new DataList(arrget.get(i)));
			Thread.sleep(100);
		}
		Long l1 = System.currentTimeMillis();
		Times.secondsList = l1 - l/1000;
	}
	
	public void searchListRecursive() throws InterruptedException {
		ArrayList<Double> arrget = c.getDataArr();
		Long l = System.currentTimeMillis();
		for (int i = 0; i < arrget.size(); i++) {
			c.searchListIterative(arrget.get(i));
			Thread.sleep(100);
			
		}
		Long l1 = System.currentTimeMillis();
		Times.secondsList = l1 - l/1000;
	}
	
	public void searchListIterative() throws InterruptedException {
		ArrayList<Double> arrget = c.getDataArr();
		Long l = System.currentTimeMillis();
		for (int i = 0; i < arrget.size(); i++) {
			c.searchListRecursive(c.getFirstDataList(), arrget.get(i));
			Thread.sleep(100);
		}
		Long l1 = System.currentTimeMillis();
		Times.secondsList = l1 - l/1000;
	}
	
	public void eliminateListIterative() throws InterruptedException {
		ArrayList<Double> arrget = c.getDataArr();
		Long l = System.currentTimeMillis();
		for (int i = 0; i < arrget.size(); i++) {
			c.deleteListIterative(arrget.get(i));
			Thread.sleep(100);
		}
		Long l1 = System.currentTimeMillis();
		Times.secondsList = l1 - l/1000;
	}
	
	public void eliminateListRecursive() throws InterruptedException {
		ArrayList<Double> arrget = c.getDataArr();
		Long l = System.currentTimeMillis();
		for (int i = 0; i < arrget.size(); i++) {
			c.deleteListRecursive(c.getFirstDataList(), arrget.get(i));
			Thread.sleep(100);
		}
		Long l1 = System.currentTimeMillis();
		Times.secondsList = l1 - l/1000;
	}
}
