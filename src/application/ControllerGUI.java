package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Exceptions.NoPressedButton;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import model.CircleClass;
import model.Controller;
import model.Direction;

public class ControllerGUI implements Initializable {

	private Controller c;

	private ArrayList<Double> ar;

	@FXML
	private Button run;
	@FXML
	private TextField n;
	@FXML
	private RadioButton add;
	@FXML
	private RadioButton search;
	@FXML
	private RadioButton delete;
	@FXML
	private RadioButton iterative;
	@FXML
	private RadioButton recursive;

	@FXML
	private Label totalTime;
	
	private Long t1;
	private Long t2;
	
	@FXML
	private Label arr;
	private boolean isRun1;
	@FXML
	private Label list;
	private boolean isRun2;
	@FXML
	private Label abb;
	private boolean isRun3;

	@FXML
	private Circle c1;
	private CircleClass cc1;

	@FXML
	private Circle c2;
	private CircleClass cc2;

	private boolean circle;


	public ControllerGUI(Controller c) {
		this.c = c;
		isRun1 = false;
		isRun2 = false;
		isRun3 = false;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cc1 = new CircleClass(c1.getRadius(), c1.getRadius(), c2.getRadius(), Direction.decreases);
		cc2 = new CircleClass(c2.getRadius(), c1.getRadius(), c2.getRadius(), Direction.increseases);
	}

	@FXML
	public void generate() throws InterruptedException {
		try {
			Long nLong = Long.parseLong(n.getText());

			if (add.isSelected()) {
				if (iterative.isSelected()) {
					iterative.setSelected(false);
					t1 = System.currentTimeMillis();
					c.allMethods(nLong, 1, 1);
				} else if (recursive.isSelected()) {
					recursive.setSelected(false);
					t1 = System.currentTimeMillis();
					c.allMethods(nLong, 1, 2);
				} else {
					throw new NoPressedButton();
				}
				add.setSelected(false);
			} else if (search.isSelected()) {
				if (iterative.isSelected()) {
					iterative.setSelected(false);
					t1 = System.currentTimeMillis();
					c.allMethods(nLong, 2, 1);
				} else if (recursive.isSelected()) {
					recursive.setSelected(false);
					t1 = System.currentTimeMillis();
					c.allMethods(nLong, 2, 2);
				} else {
					throw new NoPressedButton();
				}
				search.setSelected(false);
			} else if (delete.isSelected()) {
				if (iterative.isSelected()) {
					iterative.setSelected(false);
					t1 = System.currentTimeMillis();
					c.allMethods(nLong, 3, 1);
				} else if (recursive.isSelected()) {
					recursive.setSelected(false);
					t1 = System.currentTimeMillis();
					c.allMethods(nLong, 3, 2);
				} else {
					throw new NoPressedButton();
				}
				delete.setSelected(false);
			} else {
				throw new NoPressedButton();
			}
			
			run.setDisable(true);
			startCircle();

		} catch (NumberFormatException e) {
			Alert a = new Alert(AlertType.WARNING);
			a.setTitle("Espacio en blanco");
			a.setContentText("Usted a dejado un espacio en blanco");
			a.showAndWait();
		} catch (NoPressedButton e) {
			Alert a = new Alert(AlertType.WARNING);
			a.setTitle("No ha presionado algun boton");
			a.setContentText("Usted no ha presionado un boton");
			a.showAndWait();
		}
	}

	private void startCircle() {
		new Thread() {
			public void run() {
				while (!circle) {
					cc1.move();
					cc2.move();

					Platform.runLater(new Runnable() {
						public void run() {
							updateCircle(cc1.getR(), cc2.getR());
						}
					});
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
					}
				}
				circle = false;
			}
		}.start();
		isRun1 = true;
		isRun2 = true;
		isRun3 = true;
	}

	public void updateCircle(double cc1R, double cc2R) {
		c1.setRadius(cc1R);
		c2.setRadius(cc2R);
	}

	public void changeLabelArray(double sec) {
		arr.setText(sec/1000 + " sec");
		isRun1 = false;
		allThreadsFinish();
	}

	public void changeLabelList(double sec) {
		list.setText(sec/1000 + " sec");
		isRun2 = false;
		allThreadsFinish();
	}

	public void changeLabelABB(double sec) {
		abb.setText(sec/1000 + " sec");
		isRun3 = false;
		allThreadsFinish();
	}
	

	private void allThreadsFinish() {
		if (isRun1 == false && isRun2 == false && isRun3 == false) {
			setTotalTimer();
			circle = true;
			run.setDisable(false);			
		}
	}

	
	private void setTotalTimer() {
		t2 = System.currentTimeMillis();
		double tt = (t2 - t1)/1000;
		totalTime.setText(tt +"sec");
	}

	public Circle getC1() {
		return c1;
	}

	public void setC1(Circle c1) {
		this.c1 = c1;
	}

	public CircleClass getCc1() {
		return cc1;
	}

	public void setCc1(CircleClass cc1) {
		this.cc1 = cc1;
	}

	public Circle getC2() {
		return c2;
	}

	public void setC2(Circle c2) {
		this.c2 = c2;
	}

	public CircleClass getCc2() {
		return cc2;
	}

	public void setCc2(CircleClass cc2) {
		this.cc2 = cc2;
	}

}
