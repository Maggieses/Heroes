package pl.psi.gui;

import com.google.common.collect.Range;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import pl.psi.game.GameEngine;
import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.converter.Hero;
import pl.psi.game.move.GuiTileIf;
import pl.psi.gui.tiles.*;

import java.awt.Point;
import java.util.ArrayList;

public class MainBattleController {

    @FXML
    private GridPane gridMap;
    @FXML
    private Button passButton;

    private final Hero hero1;
    private final Hero hero2;
    private final GameEngine gameEngine;

    public MainBattleController() {
        // should come form economy
        ArrayList<Creature> creatureList1 = new ArrayList<>();
        creatureList1.add(Creature.builder().aName("C1").aAttack(Range.closed(1, 10)).aMoveRange(1).aArmor(1).aMaxHp(10).build());
        creatureList1.add(Creature.builder().aName("C2").aAttack(Range.closed(2, 10)).aMoveRange(2).aArmor(2).aMaxHp(20).build());
        creatureList1.add(Creature.builder().aName("C3").aAttack(Range.closed(3, 10)).aMoveRange(3).aArmor(3).aMaxHp(30).build());
        creatureList1.add(Creature.builder().aName("C4").aAttack(Range.closed(4, 10)).aMoveRange(14).aArmor(4).aMaxHp(40).build());
        ArrayList<Creature> creatureList2 = new ArrayList<>();
        creatureList2.add(Creature.builder().aName("C2_1").aAttack(Range.closed(1, 10)).aMoveRange(1).aArmor(1).aMaxHp(10).build());
        creatureList2.add(Creature.builder().aName("C2_2").aAttack(Range.closed(2, 10)).aMoveRange(2).aArmor(2).aMaxHp(20).build());
        creatureList2.add(Creature.builder().aName("C2_3").aAttack(Range.closed(3, 10)).aMoveRange(3).aArmor(3).aMaxHp(30).build());
        creatureList2.add(Creature.builder().aName("C2_4").aAttack(Range.closed(4, 10)).aMoveRange(14).aArmor(4).aMaxHp(40).build());

        hero1 = new Hero(creatureList1);
        hero2 = new Hero(creatureList2);
        // should come form economy END

        gameEngine = new GameEngine(hero1, hero2);
    }

    @FXML
    private void initialize() {
        refreshGui();
        passButton.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            gameEngine.pass();
        });

        gameEngine.addObserver((e) -> Platform.runLater(this::refreshGui));
    }

    private void refreshGui() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                createTile(i, j);
            }
        }
    }

    private void createTile(int aX, int aY) {
        AbstractTileFactory factory = new DefaultTileFactory();

        GuiTileIf somethingToRender = gameEngine.getByPoint(aX, aY);
        if (somethingToRender != null) {
            factory = new ObjectTileFactory(factory, somethingToRender);
        }

        if (gameEngine.getActiveCreature().getKey().equals(new Point(aX, aY))) {
            factory = new ActiveObjectTileFactoryDecorator(factory);
        }

        if (gameEngine.isAttackPossible(aX, aY)) {
            factory = new AttackPossibleTileFactoryDecorator(factory, aX, aY, gameEngine);
        }

        if (gameEngine.isMoveAllowed(aX, aY)) {
            factory = new MovePossibleTileFactoryDecorator(factory, aX, aY, gameEngine);
        }

        gridMap.add(factory.generateTile(), aX, aY);
    }
}
