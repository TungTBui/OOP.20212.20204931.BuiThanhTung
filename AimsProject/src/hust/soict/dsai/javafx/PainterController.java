package hust.soict.dsai.javafx;

import javafx.scene.paint.Color;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class PainterController {

	@FXML
	private Pane drawingAreaPane;
	
	@FXML
	private RadioButton penRadioButton;
	
	@FXML
	private RadioButton eraserRadioButton;
	
	@FXML
	void clearButtonPressed(ActionEvent event) {
		drawingAreaPane.getChildren().clear();
	}
	
	@FXML 
	void drawingAreaMouseDragged(MouseEvent event) {
		Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
		if (penRadioButton.isSelected()) {
			newCircle.setFill(Color.BLACK);
		}
		else if (eraserRadioButton.isSelected()) {
			newCircle.setFill(Color.WHITE);
		}
		drawingAreaPane.getChildren().add(newCircle);
	}
}
