package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Controller;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader fl = new FXMLLoader(getClass().getResource("app.fxml"));
			Controller c = new Controller();
			ControllerGUI cgui = new ControllerGUI(c);
			c.setCgui(cgui);
			fl.setController(cgui);
			Parent p = fl.load();
			primaryStage.setResizable(false);
			primaryStage.setTitle("Carrera de algoritmos");
			primaryStage.setScene(new Scene(p));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
