package pl.psi.gui.tiles;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import pl.psi.game.GameEngine;

import java.awt.*;

public class MovePossibleTileFactoryDecorator extends AbstractTileFactory {

    private Point location;
    private GameEngine engine;

    public MovePossibleTileFactoryDecorator(AbstractTileFactory aTileFactory, int aX, int aY, GameEngine aEngine) {
        super(aTileFactory);
        location = new Point(aX,aY);
        engine = aEngine;
    }

    @Override
    public MapTile generateTile() {
        MapTile tile = getDecorated().generateTile();
        tile.setBackground(Color.GREY);
        tile.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> engine.move(location.x,location.y));
        return tile;
    }
}
