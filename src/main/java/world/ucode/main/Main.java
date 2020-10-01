package world.ucode.main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application {

    public void start(Stage primaryStage) {
        Group g = new Group();
        Scene scene = new Scene(g,1000, 1000);

        primaryStage.setTitle("Hello World !");
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}