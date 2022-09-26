package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.shared.HasId;

public interface CharacterStatisticType extends HasId, HasImageAssetSet {
    /**
     * @return The description of this entity
     */
    String getDescription();

    /**
     * @param description The description to set for this entity
     */
    void setDescription(String description);
}
