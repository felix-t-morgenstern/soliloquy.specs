package soliloquy.specs.ruleset.gameconcepts;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.ruleset.entities.Element;
import soliloquy.specs.ruleset.entities.StatusEffectType;
import soliloquy.specs.gamestate.entities.abilities.AbilitySource;

/**
 * <b>StatusEffectResistanceCalculation</b>
 * <p>
 * A heuristic for calculating the resistance a Character has to incoming StatusEffect changes.
 * <p>
 * Intended use case is to search through a Character's various modifiers, and to calculate the
 * effective change to that Status Effect, after those resistances have been calculated.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface StatusEffectResistanceCalculation extends SoliloquyClass {
    /**
     * Calculates the effective change to a Status Effect for a specific Character, given the
     * following parameters:
     * @param character - The Character whose resistance to calculate
     * @param statusEffectType - The type of the Status Effect to be effected
     * @param baseAmount - The amount by which the Status Effect is to be effected, prior to
     * calculating resistance
     * @param stopAtZero - Whether the Ability intends to stop at zero. For instance, an ability
     * such as "Dispel Alertness" may attempt to bring Alertness down to no less than zero, even
     * though that StatusEffectType might permit negative values.
     * @param element - The Element of this effect. NB: Null values are not permitted; to have a
     * "non-elemental" attack, create an element for "non-elemental" (and then perhaps implement
     * this interface to ignore resistances for that Element).
     * @param abilitySource - The AbilitySource of this effect. May be null.
     * @return The effective change to this Character's Status Effect of the specified type, after
     * having calculated appropriate resistances.
     * @throws IllegalStateException If and only if the Character is dead or deleted
     * @throws IllegalArgumentException If and only if Character is null, StatusEffectType is null,
     * or element is null
     */
    int calculateEffectiveChange(Character character, StatusEffectType statusEffectType,
                                 int baseAmount, boolean stopAtZero, Element element,
                                 AbilitySource abilitySource)
            throws IllegalStateException, IllegalArgumentException;
}
