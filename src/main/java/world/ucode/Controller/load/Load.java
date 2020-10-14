package world.ucode.Controller.load;


import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class Load {
    @FXML
    private AnchorPane anchor;

    Label[] labels = new Label[100];

    @FXML
    public void initialize() {
         for (Integer i = 1; i < 100; i++) {
             labels[i] = new Label("load game " + i);
             labels[i].setMinWidth(600);
             labels[i].setMinHeight(100);
             labels[i].setAlignment(Pos.CENTER);
             labels[i].setId(i.toString());
             labels[i].setOnMouseClicked(e -> {
                 Label curr = (Label)e.getSource();
                 System.out.println(curr.getId());
             });
         }
         for (int i = 1; i < labels.length; i++) {
             AnchorPane.setTopAnchor(labels[i], (double)i * 100);
             anchor.setMinHeight((i + 1) * 100);
             anchor.getChildren().add(labels[i]);
         }
    }
}