package pl.fyv.bmicalc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws IOException {

        String viewUrl = "view/CalcOverview.fxml";

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource(viewUrl));

        primaryStage.setTitle("Kalkulator BMI");

        AnchorPane root = loader.load();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
