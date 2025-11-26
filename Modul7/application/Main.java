package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // Path ini harus sesuai struktur package: /Modul7/view/MainView.fxml
            AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("CRUD Pelanggan");
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}