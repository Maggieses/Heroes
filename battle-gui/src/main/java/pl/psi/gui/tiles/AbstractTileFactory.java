package pl.psi.gui.tiles;

public abstract class AbstractTileFactory {

    private final AbstractTileFactory decorated;

    public AbstractTileFactory getDecorated() {
        return decorated;
    }

    public AbstractTileFactory(AbstractTileFactory aDecorated) {
        decorated = aDecorated;
    }

    public abstract MapTile generateTile();
}
