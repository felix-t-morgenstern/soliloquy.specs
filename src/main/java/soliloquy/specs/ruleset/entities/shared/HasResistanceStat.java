package soliloquy.specs.ruleset.entities.shared;

import soliloquy.specs.ruleset.entities.character.StaticStatisticType;

/**
 * <b>HasResistanceStat</b>
 * <p>
 * An Element is type of effect which can occur to a Character, e.g., Aqua, Flora, Ignis
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface HasResistanceStat {
    /**
     * @return The statistic type which determines resistance to incoming effects of this type
     * (for example, {@link soliloquy.specs.ruleset.gameconcepts.StatusEffectResistanceCalculation#calculateEffectiveChange})
     */
    StaticStatisticType resistanceStatisticType();
}
