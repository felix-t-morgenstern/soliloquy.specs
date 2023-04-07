package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.HasName;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.abilities.AbilitySource;
import soliloquy.specs.ruleset.entities.character.StaticStatisticType;
import soliloquy.specs.ruleset.entities.character.StatusEffectType;
import soliloquy.specs.ruleset.gameconcepts.DamageResistanceCalculation;

/**
 * <b>Element</b>
 * <p>
 * An Element is type of effect which can occur to a Character, e.g., Aqua, Flora, Ignis
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface Element extends HasName, HasId, HasDescription, HasImageAssetSet,
        HasResistanceStat {
}
