package soliloquy.specs.ruleset.entities.character;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.HasName;
import soliloquy.specs.io.graphics.renderables.HasColorShifts;
import soliloquy.specs.ruleset.entities.shared.HasDescription;
import soliloquy.specs.ruleset.entities.shared.HasImageAssetSet;
import soliloquy.specs.ruleset.entities.actonroundendandcharacterturn.EffectsCharacterOnRoundOrTurnChange;

public interface StatisticType extends EffectsCharacterOnRoundOrTurnChange, HasId,
        HasName, HasDescription, HasImageAssetSet, HasColorShifts {
}
