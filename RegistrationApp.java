package Exercise_4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class RegistrationApp extends Application {
	@Override
	public void start(Stage primaryStage) {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20));
		grid.setVgap(10);
		grid.setHgap(10);

		// TODO: Create Labels and TextFields
		Label studentName = new Label("Student Name");
		studentName.setFont(new Font("Times New Roman", 20));
		TextField inputName = new TextField();
		grid.add(studentName, 0, 0);
		grid.add(inputName, 1, 0);
		
		// TODO: Create the Register Button
		Label courseCode = new Label("Course Code");
		courseCode.setFont(new Font("Times New Roman", 20));
		ComboBox<String> inputCourse = new ComboBox<String>();
		inputCourse.getItems().addAll(
				"CMP 269",
				"CMP 168",
				"ENG 121",
				"MAT 313",
				"AAS 232"
				);
		grid.add(courseCode, 0, 2);
		grid.add(inputCourse, 1, 2);
		
		// TODO: Implement the Button Action using a Lambda
		Button register = new Button("Register");
		register.setFont(new Font(14));
		
		Label status = new Label("Status");
//		status.setFont(new Font(14));
		status.setStyle("-fx-border-color: black; -fx-padding: 10;");
		
		register.setOnAction(event -> {
			status.setText("Registration Successful for " + inputName.getText() + " in " + inputCourse.getValue());
		});
		
		HBox box = new HBox();
		box.setSpacing(10);
		box.setHgrow(status, Priority.ALWAYS);
		box.setMinSize(400, 10);;
		
		grid.add(register, 0, 4);
		grid.add(status, 0, 6);
		grid.add(box, 0, 6);
		GridPane.setColumnSpan(status, 3);
		GridPane.setColumnSpan(box, 3);

		Scene scene = new Scene(grid, 640, 480);
		primaryStage.setTitle("Lehman Course Registration");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
