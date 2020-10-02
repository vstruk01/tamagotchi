package world.ucode.menu;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import world.ucode.load.Load;
import world.ucode.main.Main;

public class MenuController {
    final static Load l = new Load();

    @FXML
    private Label newGame;

    @FXML
    private Label loadGame;

    @FXML
    private Label exit;

    public void handleNewGame(MouseEvent mouseEvent) {

//        if (mouseEvent.isPrimaryButtonDown()) {
            System.out.println("New Game");
            Main.stage.setTitle("new Game");
            Main.stage.setScene(Main.scenes.get(Main.SceneType.GAME));
            Main.stage.centerOnScreen();
//        }
    }
    public void handleLoadGame(MouseEvent mouseEvent) {
//        if (mouseEvent.isPrimaryButtonDown()) {
            System.out.println("Load Menu");
            Main.stage.setTitle("Load Game");
            Main.stage.setScene(Main.scenes.get(Main.SceneType.LOAD));
            Main.stage.centerOnScreen();
//        }
    }

    public void handleExit(MouseEvent mouseEvent) {
        if (mouseEvent.isPrimaryButtonDown()) {
            System.out.println("Exit");
            Main.stage.setTitle("Load Game");
            Main.stage.setScene(Main.scenes.get(Main.SceneType.EXIT));
            Main.stage.centerOnScreen();
        }
    }
}