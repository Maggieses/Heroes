package pl.psi.game.move;

public class Obstacle implements GuiTileIf {

    @Override
    public String getDisplayName() {
        return "X";
    }

    @Override
    public boolean isCreature() {
        return false;
    }
}
