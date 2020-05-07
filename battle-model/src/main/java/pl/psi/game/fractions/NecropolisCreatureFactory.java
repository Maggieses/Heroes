package pl.psi.game.fractions;


import com.google.common.collect.Range;

public class NecropolisCreatureFactory {

    public Creature createCreature(int aTier) {
        switch (aTier) {
            case 1: {
                return Creature.builder().aMaxHp(6).aAttack(Range.closed(1, 3)).aName("Skeleton").aArmor(6).aMoveRange(5).build();
            }
            default:
                throw new IllegalArgumentException("You have to pass tier 1-7");
        }
    }
}
