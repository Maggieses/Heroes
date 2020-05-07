package pl.psi.gui.tiles;


import pl.psi.game.move.GuiTileIf;

public class ObjectTileFactory extends AbstractTileFactory {

    private final GuiTileIf somethingToRender;

    public ObjectTileFactory(AbstractTileFactory aDecorated, GuiTileIf aSomethingToRender) {
        super(aDecorated);
        somethingToRender =aSomethingToRender;
    }

    @Override
    public MapTile generateTile() {
        MapTile ret = getDecorated().generateTile();
        ret.setName(somethingToRender.getDisplayName());
        return ret;
    }
}
