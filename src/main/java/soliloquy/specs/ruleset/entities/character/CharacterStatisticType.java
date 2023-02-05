package soliloquy.specs.ruleset.entities.character;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.HasName;
import soliloquy.specs.graphics.renderables.HasColorShifts;
import soliloquy.specs.ruleset.entities.HasDescription;
import soliloquy.specs.ruleset.entities.HasImageAssetSet;
import soliloquy.specs.ruleset.entities.actonroundendandcharacterturn.EffectsCharacterOnRoundOrTurnChange;

public interface CharacterStatisticType extends EffectsCharacterOnRoundOrTurnChange, HasId,
        HasName, HasDescription, HasImageAssetSet, HasColorShifts {
}
