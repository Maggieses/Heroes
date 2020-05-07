package pl.psi.game.hero.artifacts;

import pl.psi.game.spellbook.SpellInfo;

import java.util.ArrayList;
import java.util.List;

public class ArtifactsInfoFactory {

    private final static String QUIER_EYE_OF_THE_DRAGON = "Quiet Eye of the Dragon";

    private final static List<ArtifactInfo> artifactList = new ArrayList<>();
    {
        artifactList.add(ArtifactInfo.builder().aCost(1).aDescription("x").aName(QUIER_EYE_OF_THE_DRAGON).aLocation(ArtifactInfo.Location.FINGERS).build());
    }

   // public static ArtifactInfo getArtifact(String aName){
    //    return artifactList.stream().filter(s -> s.getName().endsWith(aName)).findAny().orElseThrow();
   // }

    public static List<SpellInfo> getByType(ArtifactInfo.Location aTier){
        return new ArrayList<>();
    }

}
