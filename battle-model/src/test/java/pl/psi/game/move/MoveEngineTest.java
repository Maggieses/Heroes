package pl.psi.game.move;

import org.junit.jupiter.api.Test;
import pl.psi.game.Board;
import pl.psi.game.fractions.Creature;
import pl.psi.game.move.MoveEngine;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class MoveEngineTest {

    @Test
    void moveShouldBePossible(){
        Creature c = Creature.builder().aMoveRange(1).build();
        Board board = new Board();
        board.putCreature(1,1, c);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(1,1),c);

        assertTrue(moveEngine.isMovePossible(1,2));
        assertTrue(moveEngine.isMovePossible(2,1));
        assertTrue(moveEngine.isMovePossible(0,1));
        assertTrue(moveEngine.isMovePossible(1,0));
    }

    @Test
    void moveCreature(){
        Creature c = Creature.builder().aMoveRange(1).build();
        Board board = new Board();
        board.putCreature(1,1, c);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(1,1), c);
        moveEngine.move(1,2);

        assertEquals(c, board.getCreature(1,2));
        assertNull(board.getCreature(1,1));
    }

}