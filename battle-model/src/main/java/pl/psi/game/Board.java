package pl.psi.game;

import pl.psi.game.fractions.Creature;
import pl.psi.game.move.GuiTileIf;
import pl.psi.game.move.Obstacle;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Board {

    private final Map<Point, GuiTileIf> board;
    public final static int BOARD_WIDTH = 14;
    public final static int BOARD_HIGH = 9;

    public Board() {
        board = new HashMap<>();
        board.put(new Point(7,2), new Obstacle());
        board.put(new Point(7,3), new Obstacle());
        board.put(new Point(7,4), new Obstacle());
        board.put(new Point(7,5), new Obstacle());
        board.put(new Point(7,6), new Obstacle());
        board.put(new Point(7,7), new Obstacle());
    }

    public void putCreature(int x, int y, Creature aCreature) {
        if (x > BOARD_WIDTH || x < 0 || y > BOARD_HIGH || y < 0) {
            throw new IllegalArgumentException("You tried put creature outside the board");
        }

        if (!isTileEmpty(x, y)) {
            throw new IllegalArgumentException("Field isn't empty");
        }

        board.put(new Point(x, y), aCreature);
    }

    public boolean isTileEmpty(int x, int y) {
        return !board.containsKey(new Point(x, y));
    }

    public Creature getCreature(int x, int y) {
        if (board.get(new Point(x, y)) != null) {
            if (board.get(new Point(x, y)).isCreature()) {
                return (Creature) board.get(new Point(x, y));
            }
        }
        return null;
    }

    public GuiTileIf getTile(int x, int y) {
        return board.get(new Point(x, y));
    }

    public Optional<Point> getCreatureLocation(Creature c1) {
        return board.keySet().stream().filter(p -> board.get(p).equals(c1)).findAny();
    }

    public void move(int x, int y, Creature activeCreature) {
        Point oldPosition = getCreatureLocation(activeCreature).get();
        try {
            board.remove(oldPosition);
            putCreature(x, y, activeCreature);
        } catch (Exception e) {
            putCreature(oldPosition.x, oldPosition.y, activeCreature);
        }
    }
}
