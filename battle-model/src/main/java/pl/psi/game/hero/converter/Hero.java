package pl.psi.game.hero.converter;

import lombok.Builder;
import lombok.Getter;
import pl.psi.game.fractions.Creature;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Hero {

    private final List<Creature> creatures;
    private final int knowledge;

    @Builder
    public Hero(List<Creature> aCreatures, int aKnowledge) {
        creatures = aCreatures;
        knowledge = aKnowledge;
    }

    public List<Creature> getCreatures() {
        return new ArrayList<>(creatures);
    }
}
