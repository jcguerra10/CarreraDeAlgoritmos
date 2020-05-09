package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import model.Controller;

public class ControllerGUI implements Initializable {

	private Controller c;

	private ArrayList<Double> ar;

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
	private Label arr;
	@FXML
	private Label list;
	@FXML
	private Label abb;
	
	public ControllerGUI(Controller c) {
		this.c = c;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	public void generate() throws InterruptedException{
		try {
			Long nLong = Long.parseLong(n.getText());
			
			if (add.isSelected()) {
				if (iterative.isSelected()) {
					iterative.setSelected(false);
					c.allMethods(nLong, 1, 1);
				} else if (recursive.isSelected()) {
					recursive.setSelected(false);
					c.allMethods(nLong, 1, 2);
				} else {
					advice();
				}
				add.setSelected(false);
			} else if (search.isSelected()) {
				if (iterative.isSelected()) {
					iterative.setSelected(false);
					c.allMethods(nLong, 2, 1);
				} else if (recursive.isSelected()) {
					recursive.setSelected(false);
					c.allMethods(nLong, 2, 2);
				} else {
					advice();
				}
				search.setSelected(false);
			} else if (delete.isSelected()) {
				if (iterative.isSelected()) {
					iterative.setSelected(false);
					c.allMethods(nLong, 3, 1);
				} else if (recursive.isSelected()) {
					recursive.setSelected(false);
					c.allMethods(nLong, 3, 2);
				} else {
					advice();
				}
				delete.setSelected(false);
			}else {
				advice();
			}	
			
		} catch (NumberFormatException e) {
			Alert a = new Alert(AlertType.WARNING);
			a.setTitle("Espacio en blanco");
			a.setContentText("Usted a dejado un espacio en blanco");
			a.showAndWait();
		}
	}

	private void advice() {
		Alert a = new Alert(AlertType.WARNING);
		a.setTitle("No ha presionado algun boton");
		a.setContentText("Usted no ha presionado un boton");
		a.showAndWait();
	}

	public void changeLabelArray(double sec) {
		arr.setText(sec + " sec");
	}
	
	public void changeLabelList(double sec) {
		list.setText(sec + " sec");
	}
	
	public void changeLabelABB(double sec) {
		abb.setText(sec + " sec");
	}

}
