package com.company;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application {
    public static Stage window;
    //public static Scene second_scene;
    @Override
    public void start(Stage PrimaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Design.fxml"));
        window = PrimaryStage;
        window.setTitle("Weather"); //programme name
        window.setScene(new Scene(root, 273, 400)); //set new scene uploaded from FXML folder
        window.setResizable(false);
        window.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }

}
