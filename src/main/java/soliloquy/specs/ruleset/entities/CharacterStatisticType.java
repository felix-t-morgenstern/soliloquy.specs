package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.HasName;
import soliloquy.specs.graphics.renderables.HasColorShifts;

public interface CharacterStatisticType extends HasId, HasName, HasImageAssetSet, HasColorShifts {
    /**
     * @return The description of this entity
     */
    String getDescription();

    /**
     * @param description The description to set for this entity
     */
    void setDescription(String description);
}
