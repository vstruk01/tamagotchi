package world.ucode.load;


import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextAlignment;

public class Load {
    @FXML
    private AnchorPane anchor;

    @FXML
    public void initialize() {
        init();
    }
    Label[] labels = new Label[100];

    public void init() {
         for (Integer i = 0; i < 100; i++) {
             labels[i] = new Label("load game " + i);
             labels[i].setMinWidth(500);
             labels[i].setMinHeight(100);
             labels[i].setAlignment(Pos.CENTER);
             labels[i].setId(i.toString());
             labels[i].setOnMouseClicked(e -> {
                 Label curr = (Label)e.getSource();
                 System.out.println(curr.getId());
             });
         }
         for (int i = 0; i < labels.length; i++) {
             AnchorPane.setTopAnchor(labels[i], (double)i * 100);
             anchor.setMinWidth(500);
             anchor.setMinHeight((i + 1) * 100);
             anchor.getChildren().add(labels[i]);
         }
    }
}