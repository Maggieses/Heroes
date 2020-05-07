package pl.psi.game;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.converter.Hero;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameEngineTest {

    @Test
    void fastestCreatureShouldBeFirst(){
        List<Creature> creatures = new ArrayList<>();
        Creature c1 = Creature.builder().aMoveRange(10).build();
        Creature c2 = Creature.builder().aMoveRange(4).build();
        creatures.add(c1);
        creatures.add(c2);
        List<Creature> creatures2 = new ArrayList<>();
        Creature c2_1 = Creature.builder().aMoveRange(11).build();
        Creature c2_2 = Creature.builder().aMoveRange(7).build();
        creatures2.add(c2_1);
        creatures2.add(c2_2);
        Hero hero1 = new Hero(creatures, 0);
        Hero hero2 = new Hero(creatures2, 0);

        GameEngine gameEngine = new GameEngine(hero1, hero2);

        assertEquals(c2_1, gameEngine.getActiveCreature().getValue());
        gameEngine.pass();
        assertEquals(c1, gameEngine.getActiveCreature().getValue());
        gameEngine.pass();
        assertEquals(c2_2, gameEngine.getActiveCreature().getValue());
        gameEngine.pass();
        assertEquals(c2, gameEngine.getActiveCreature().getValue());
    }

    @Test
    void checkNewTurn(){
        List<Creature> creatures = new ArrayList<>();
        Creature c1 = Creature.builder().aMoveRange(10).build();
        Creature c2 = Creature.builder().aMoveRange(4).build();
        creatures.add(c1);
        creatures.add(c2);
        List<Creature> creatures2 = new ArrayList<>();
        Creature c2_1 = Creature.builder().aMoveRange(11).build();
        Creature c2_2 = Creature.builder().aMoveRange(7).build();
        creatures2.add(c2_1);
        creatures2.add(c2_2);
        Hero hero1 = new Hero(creatures, 0);
        Hero hero2 = new Hero(creatures2, 0);

        GameEngine gameEngine = new GameEngine(hero1, hero2);

        assertEquals(c2_1, gameEngine.getActiveCreature().getValue());
        gameEngine.pass();
        assertEquals(c1, gameEngine.getActiveCreature().getValue());
        gameEngine.pass();
        assertEquals(c2_2, gameEngine.getActiveCreature().getValue());
        gameEngine.pass();
        assertEquals(c2, gameEngine.getActiveCreature().getValue());


        gameEngine.pass();
        assertEquals(c2_1, gameEngine.getActiveCreature().getValue());
    }

    @Test
    void checkResetCounterAttack(){
        List<Creature> creatures = new ArrayList<>();
        Creature attacker1 = Creature.builder().aMaxHp(10).aAttack(Range.closed(1,1)).build();
        Creature attacker2 = Creature.builder().aMaxHp(10).aAttack(Range.closed(1,1)).build();
        creatures.add(attacker1);
        creatures.add(attacker2);
        List<Creature> creatures2 = new ArrayList<>();
        Creature defender = Creature.builder().aMaxHp(100).aAttack(Range.closed(1,1)).build();
        creatures2.add(defender);
        Hero hero1 = new Hero(creatures, 0);
        Hero hero2 = new Hero(creatures2, 0);
        GameEngine gameEngine = new GameEngine(hero1, hero2);

        attacker1.attack(defender);
        attacker2.attack(defender);
        //new turn
        gameEngine.pass();
        gameEngine.pass();
        gameEngine.pass();
        attacker1.attack(defender);

        assertEquals(97, defender.getCurrentHp());
        assertEquals(10, attacker2.getCurrentHp());
        assertEquals(8, attacker1.getCurrentHp());
    }
}