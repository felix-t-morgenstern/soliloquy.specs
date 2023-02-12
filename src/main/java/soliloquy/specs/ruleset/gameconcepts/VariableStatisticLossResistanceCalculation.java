package soliloquy.specs.ruleset.gameconcepts;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.abilities.AbilitySource;
import soliloquy.specs.ruleset.entities.character.VariableStatisticType;
import soliloquy.specs.ruleset.entities.Element;

/**
 * <b>VariableStatisticLossResistanceCalculation</b>
 * <p>
 * A heuristic for calculating the resistance a Character has to Abilities (or other
 * movementEvents) which change that Character's status effect level or variable statistic current
 * value.
 * <p>
 * Intended use case is to search through a Character's various modifiers, and to calculate the
 * effective change to that status effect or variable statistic, after those resistances have been
 * calculated.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface VariableStatisticLossResistanceCalculation extends SoliloquyClass {

    /**
     * Calculates the effective change to a Status Effect for a specific Character, given the
     * following parameters:
     *
     * @param character             The Character whose resistance to calculate
     * @param variableStatisticType The type of variable statistic to be effected
     * @param baseAmount            The amount by which the Status Effect is to be effected, prior
     *                              to calculating resistance
     * @param element               The Element of this effect. May be null.
     * @param abilitySource         The AbilitySource of this effect. May be null.
     * @return The effective change to this Character's Status Effect of the specified type, after
     *         having calculated appropriate resistances.
     * @throws IllegalStateException    If and only if the Character is dead or deleted
     * @throws IllegalArgumentException If and only if Character is null, StatusEffectType is null,
     *                                  or element is null in a case which does not permit it to be
     *                                  null
     */
    int calculateEffectiveChange(Character character, VariableStatisticType variableStatisticType,
                                 int baseAmount, Element element, AbilitySource abilitySource)
            throws IllegalStateException, IllegalArgumentException;
}
