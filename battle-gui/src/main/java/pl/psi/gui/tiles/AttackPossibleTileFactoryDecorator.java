package pl.psi.gui.tiles;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import pl.psi.game.GameEngine;

import java.awt.*;

public class AttackPossibleTileFactoryDecorator extends AbstractTileFactory {

    private Point location;
    private GameEngine engine;

    public AttackPossibleTileFactoryDecorator(AbstractTileFactory aTileFactory, int aX, int aY, GameEngine aEngine) {
        super(aTileFactory);
        location = new Point(aX,aY);
        engine = aEngine;
    }

    @Override
    public MapTile generateTile() {
        MapTile tile = getDecorated().generateTile();
        tile.setBackground(Color.RED);
        tile.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> engine.attack(location.x, location.y));
        return tile;
    }
}
