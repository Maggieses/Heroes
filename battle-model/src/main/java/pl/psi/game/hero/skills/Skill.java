package pl.psi.game.hero.skills;

import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.converter.Hero;

public class Skill {

    private SkillInfo skillInfo;

    public Skill(SkillInfo skillInfo) {
        this.skillInfo = skillInfo;
    }

    public void cast(Creature creature){ }
    public void buffSkill(Hero hero) {}
    public void debuffSpell(Creature creature) {}

}
