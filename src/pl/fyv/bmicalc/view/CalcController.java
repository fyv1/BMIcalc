package pl.fyv.bmicalc.view;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private Stage stage;

    public CalcController() { }

    @FXML
    private void initialize() {
        subjectButton.setOnAction(this::showBmiResult);

    }
    @FXML
    private void showBmiResult(ActionEvent actionEvent) {

        if(!ifFieldsNotNull()) displayError();

        else {
            double mass = Double.parseDouble(massInput.getText());
            double height = Double.parseDouble(heightInput.getText());
            height /= 100; //from cm to m

            BmiCalc bmiCalc = new BmiCalc(new SimpleDoubleProperty(height), new SimpleDoubleProperty(mass));

            bmiResult.setText(bmiCalc.interprete());
        }
    }

    public void setMain(Main main) {
        this.main = main;
    }

    private boolean ifFieldsNotNull() {

        if(massInput.getText() == null || massInput.getText().length() == 0) return false;
        else if(heightInput.getText() == null || heightInput.getText().length() == 0) return false;
        else return true;
    }

    private void displayError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(stage);
        alert.setTitle("Wystąpił błąd");
        alert.setHeaderText("Błąd:");
        alert.setContentText("Uzupełnij puste pola!");
        alert.showAndWait();
    }

}
