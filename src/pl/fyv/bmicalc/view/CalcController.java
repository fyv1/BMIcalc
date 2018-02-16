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
    private BmiCalc bmiCalc;

    public CalcController() { }

    @FXML
    private void initialize() {
        subjectButton.setOnAction(this::showBmiResult);

    }
    @FXML
    private void showBmiResult(ActionEvent actionEvent) {

        checkFields();

        double mass = Double.parseDouble(massInput.getText());
        double height = Double.parseDouble(heightInput.getText());
        height /= 100; //from cm to m

        bmiCalc = new BmiCalc(new SimpleDoubleProperty(height), new SimpleDoubleProperty(mass));

        bmiResult.setText(bmiCalc.interprete());
    }

    public void setMain(Main main) {
        this.main = main;
    }

    private void checkFields() {
        String errmessage = "";
        if(massInput.getText()==null) errmessage += "Puste pole \"masa\"\n";
        if(heightInput.getText()==null) errmessage += "Puste pole \"wysokość\"\n";

        if(errmessage.length() != 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Wystąpił błąd");
            alert.setHeaderText("Błąd:");
            alert.setContentText(errmessage);
            alert.showAndWait();
        }
    }

}
