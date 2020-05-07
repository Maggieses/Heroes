package pl.psi.game.hero.skills;

import pl.psi.game.AbstractItemInfo;

public class SkillInfo extends AbstractItemInfo {

    public enum SkillType{
        ARCHERY,
        OFFENCE,
        LEARNING,
        RESISTANCE
    }

    public SkillInfo(String aName, String aDescription, int aCost) {

        super(aName, aDescription, aCost);
    }


}
