package pl.psi.game.spellbook;

import java.util.ArrayList;
import java.util.List;

public class SpellBookInfoFactory {

    private final static String MAGIC_ARROW = "Magic arrow";

    private final static List<SpellInfo> spellList = new ArrayList<>();
    {
        spellList.add(SpellInfo.builder().aCost(1).aDescription("x").aDuration("1/magic power").aManaCost(1).aName(MAGIC_ARROW).aTier(1).aType(SpellInfo.Type.AIR).build());
    }

    public static SpellInfo getSpell(String aName){
       return spellList.stream().filter(s -> s.getName().endsWith(aName)).findAny().orElseThrow();
    }

    public static List<SpellInfo> getSpellsByTier(int aTier){
        return new ArrayList<>();
    }

    public static List<SpellInfo> getSpellsByType(SpellInfo.Type type){
        return new ArrayList<>();
    }
}
