package pl.fyv.bmicalc;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pl.fyv.bmicalc.model.BmiCalc;
import pl.fyv.bmicalc.view.CalcController;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws IOException {

        String viewUrl = "/CalcOverview.fxml";

        FXMLLoader loader = new FXMLLoader();
        //loader.setLocation(Main.class.getResource(viewUrl));
        loader.setLocation(getClass().getResource(viewUrl));

        primaryStage.setTitle("Kalkulator BMI");

        AnchorPane root = loader.load();

        CalcController controller = loader.getController();
        controller.setMain(this);
        controller.setStage(primaryStage);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
