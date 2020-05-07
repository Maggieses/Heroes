package pl.psi.game.fractions;

import com.google.common.collect.Range;
import pl.psi.game.fractions.Creature;

public class ShootingCreature extends Creature {

    private boolean shouldShoot = true;

    public ShootingCreature(int aMaxHp, Range<Integer> aAttack, int aArmor, String aName, int aMoveRange) {
        super(aMaxHp, aAttack, aArmor, aName, aMoveRange);
    }

    @Override
    public void attack(Creature aDefender) {
        if (shouldShoot){
            shoot(aDefender);
        }
        else
        {
            super.attack(aDefender);
        }
    }

    private void shoot(Creature aDefender) {
        dealDamage(aDefender);
    }

    @Override
    public boolean canShoot() {
        return true;
    }
}
