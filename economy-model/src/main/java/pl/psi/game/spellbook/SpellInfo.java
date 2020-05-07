package pl.psi.game.spellbook;

import lombok.Builder;
import lombok.Getter;
import pl.psi.game.AbstractItemInfo;

@Getter
public class SpellInfo extends AbstractItemInfo {

    public enum Type{
        FIRE,
        WATER,
        AIR,
        EARTH;
    }

    private final Type type;
    private final int tier;
    private final int manaCost;
    private String duration;



    @Builder
    SpellInfo(String aName, String aDescription, int aCost, int aTier, int aManaCost, Type aType, String aDuration) {
        super(aName,aDescription,aCost);
        tier = aTier;
        manaCost = aManaCost;
        type = aType;
        duration = aDuration;
    }
}
