package pl.psi.game.hero.artifacts;

import lombok.Builder;
import lombok.Getter;
import pl.psi.game.AbstractItemInfo;

@Getter
public class ArtifactInfo extends AbstractItemInfo {

    private final Location location;

    public enum Location{
        HEAD,
        NECK,
        TORSO,
        SHOULDERS,
        RIGHT_HAND,
        LEFT_HAND,
        FINGERS,
        FEET
    }

    @Builder
    public ArtifactInfo(String aName, String aDescription, int aCost, Location aLocation) {
        super(aName, aDescription, aCost);
        location = aLocation;
    }
}
