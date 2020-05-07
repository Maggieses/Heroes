package pl.psi.game.fractions;

import com.google.common.collect.Range;
import lombok.Builder;
import lombok.Getter;
import pl.psi.game.move.GuiTileIf;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

@Getter
public class Creature implements GuiTileIf, PropertyChangeListener {

    private final int maxHp;
    private final Range<Integer> attack;
    private final int armor;
    private final String name;
    private int currentHp;
    private boolean canCounterAttacked;
    private final int moveRange;
    private DealDamageCounterStrategyIf dealDamageCounterStrategy;

    @Builder
    public Creature(int aMaxHp, Range<Integer> aAttack, int aArmor, String aName, int aMoveRange) {
        maxHp = aMaxHp;
        attack = aAttack;
        currentHp = maxHp;
        armor = aArmor;
        canCounterAttacked = true;
        name = aName;
        moveRange = aMoveRange;
        dealDamageCounterStrategy = new DefaultDamageCounterStrategy();
    }

    public Creature(int aMaxHp, Range<Integer> aAttack, int aArmor) {
        maxHp = aMaxHp;
        attack = aAttack;
        currentHp = maxHp;
        armor = aArmor;
        canCounterAttacked = true;
        name = "";
        moveRange = 0;
    }

    public void attack(Creature aDefender) {
        dealDamage(aDefender);
        if (aDefender.canCounterAttacked) {
            aDefender.counterAttack(this);
        }
    }

    @Override
    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(System.lineSeparator());
        sb.append(currentHp);
        sb.append("/");
        sb.append(maxHp);
        return sb.toString();
    }

    private void counterAttack(Creature aDefender) {
        dealDamage(aDefender);
        canCounterAttacked = false;
    }

    void dealDamage(Creature aDefender) {
        int damageToDeal = dealDamageCounterStrategy.countDamageToDeal(this, aDefender);
        aDefender.currentHp = aDefender.currentHp - damageToDeal;
    }

    public boolean canShoot(){
        return false;
    }

    @Override
    public boolean isCreature() {
        return true;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        canCounterAttacked = true;
    }

    public void setDealDamageCountStrategy(DealDamageCounterWithIgnoreArmorStrategy aDealDamageCounterWithIgnoreArmorStrategy) {
        dealDamageCounterStrategy = aDealDamageCounterWithIgnoreArmorStrategy;
    }
}
