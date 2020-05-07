package pl.psi.gui.tiles;


import javafx.scene.paint.Color;

public class ActiveObjectTileFactoryDecorator extends AbstractTileFactory {
    public ActiveObjectTileFactoryDecorator(AbstractTileFactory aTileFactory) {
        super(aTileFactory);
    }

    @Override
    public MapTile generateTile() {
        MapTile tile = getDecorated().generateTile();
        tile.setBackground(Color.GREEN);
        return tile;
    }
}
