package soliloquy.specs.ruleset.gameconcepts;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.ruleset.entities.Element;

/**
 * <b>DamageResistanceCalculation</b>
 * <p>
 * Calculates a Character's resistance to incoming decreases to a VariableStatisticType, e.g.
 * Health, Endurance, etc. In other words--it is damage resistance.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface DamageResistanceCalculation extends SoliloquyClass {

    /**
     * Calculates the effective change to a
     * {@link soliloquy.specs.ruleset.entities.character.VariableStatisticType} for a specific
     * Character, intended to be called by
     * {@link soliloquy.specs.ruleset.entities.character.VariableStatisticType#alter}
     *
     * @param character  The Character whose resistance to calculate
     * @param baseAmount The amount by which the Status Effect is to be effected, prior
     *                   to calculating resistance
     * @param element    The Element of this effect. May be null.
     * @return The effective change to this Character's Status Effect of the specified type, after
     *         having calculated appropriate resistances.
     * @throws IllegalStateException    If and only if the Character is dead or deleted
     * @throws IllegalArgumentException If and only if character or element are null
     */
    int calculateEffectiveChange(Character character, int baseAmount, Element element)
            throws IllegalStateException, IllegalArgumentException;
}
