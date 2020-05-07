package pl.psi.game.move;

import pl.psi.game.Board;
import pl.psi.game.GameEngine;
import pl.psi.game.fractions.Creature;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.AbstractMap;
import java.util.HashMap;

public class MoveEngine implements PropertyChangeListener {

    private HashMap.Entry<Point, Creature> activeCreature;
    private final Board board;
    private PropertyChangeSupport propertyChangeSupport;

    public MoveEngine(Board aBoard) {
        board = aBoard;
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public boolean isMovePossible(int x, int y) {
        return board.isTileEmpty(x,y) && new Point(x,y).distance(activeCreature.getKey()) <= activeCreature.getValue().getMoveRange();
    }

    public void move(int x, int y) {
        Point oldPosition = activeCreature.getKey();
        board.move(x,y,activeCreature.getValue());
        activeCreature = new AbstractMap.SimpleEntry<>(new Point(x,y), activeCreature.getValue());
        propertyChangeSupport.firePropertyChange(GameEngine.CREATURE_MOVED, oldPosition, activeCreature.getKey());
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        activeCreature = (HashMap.Entry<Point, Creature>)aPropertyChangeEvent.getNewValue();
    }

    void setActiveCreature(Point aPoint, Creature aCreature) {
        activeCreature = new AbstractMap.SimpleEntry<>(aPoint, aCreature);
    }

    public void addObserver(String aPropertyType, PropertyChangeListener aObserver){
        propertyChangeSupport.addPropertyChangeListener(aPropertyType, aObserver);
    }

    public void removeObserver(PropertyChangeListener aObserver){
        propertyChangeSupport.removePropertyChangeListener(aObserver);
    }
}
