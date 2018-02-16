package pl.fyv.bmicalc.view;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pl.fyv.bmicalc.Main;
import pl.fyv.bmicalc.model.BmiCalc;

public class CalcController {

    @FXML
    private Label bmiResult;
    @FXML
    private TextField massInput;
    @FXML
    private TextField heightInput;
    @FXML
    private Button subjectButton;

    private Main main;
    private BmiCalc bmiCalc;

    public CalcController() { }

    @FXML
    private void initialize() {
        subjectButton.setOnAction(this::showBmiResult);

    }
    @FXML
    private void showBmiResult(ActionEvent actionEvent) {

        double mass = Double.parseDouble(massInput.getText());
        double height = Double.parseDouble(heightInput.getText());
        height /= 100;

        bmiCalc = new BmiCalc(new SimpleDoubleProperty(height), new SimpleDoubleProperty(mass));

        bmiResult.setText(bmiCalc.interprete());
    }

    public void setMain(Main main) {
        this.main = main;
    }

}
