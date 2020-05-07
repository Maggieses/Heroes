package pl.psi.gui.tiles;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MapTile extends StackPane {

    private final Rectangle rect;
    private final Label label;
    private String name;

    MapTile(String aName) {
        name = aName;
        rect = new Rectangle(60, 60);
        rect.setFill(Color.WHITE);
        rect.setStroke(Color.RED);
        getChildren().add(rect);
        label = new Label(name);
        getChildren().add(label);
    }

    void setName(String aName){
        label.setText(aName);
    }

    Rectangle getRect() {
        return rect;
    }

    void setBackground(Color aColor) {
        rect.setFill(aColor);
    }

}
