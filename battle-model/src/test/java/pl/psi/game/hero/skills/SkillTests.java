package pl.psi.game.hero.skills;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.converter.Hero;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SkillTests {

    @Test
    void archerySkillShouldIncreaseDamage() {
        //given
        int lowAttack = 50, highAttack = 100;
        Skill offenceSkill = new Skill(SkillInfoFactory.getSkill(SkillInfo.SkillType.OFFENCE));
        Creature creature = Creature.builder().aAttack(Range.closed(lowAttack, highAttack)).build();

        //when
        offenceSkill.cast(creature);

        //then
        Range<Integer> attackAfterSkill = creature.getAttack();
        assertThat(attackAfterSkill).isEqualTo(Range.closed(55,110));

    }

}
