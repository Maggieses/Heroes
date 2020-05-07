package pl.psi.game.hero.artifacts;

import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.converter.Hero;

public class Artifact {
    public Artifact() {};
    public Artifact(ArtifactInfo artifactInfo){};
    public void buffSkill(Hero hero) {};
    //public void buffSpell(Spell spell){};
    public void buffCreature(Creature creature){};

    public void debuffSkill(Hero hero) {
    }
}
