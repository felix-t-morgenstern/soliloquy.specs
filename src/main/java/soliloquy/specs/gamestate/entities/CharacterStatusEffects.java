package soliloquy.specs.gamestate.entities;

import soliloquy.specs.gamestate.entities.exceptions.EntityDeletedException;
import soliloquy.specs.ruleset.entities.character.StatusEffectType;

import java.util.Map;

/**
 * <b>CharacterStatusEffects</b>
 * <p>
 * It can return a set of all status effects whose values are non-zero, identified by status effect
 * type Id.
 * <p>
 * It can get the value of a specific status effect.
 * <p>
 * It can set the value of a specific status effect.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface CharacterStatusEffects extends Deletable {
    /**
     * @param statusEffectType The type of the Status Effect whose level to retrieve
     * @return The current value of the specified StatusEffectType for this Character
     * @throws EntityDeletedException   If this Character is deleted or dead
     * @throws IllegalArgumentException If and only if statusEffectTypeId is null, empty, or does
     *                                  not correspond to a valid StatusEffectType
     */
    Integer getStatusEffectLevel(StatusEffectType statusEffectType)
            throws EntityDeletedException, IllegalArgumentException;

    /**
     * @return A read-only Map, with an entry for every Status Effect whose value for this
     *         Character is not zero.
     * @throws EntityDeletedException If this Character is deleted or dead
     */
    Map<StatusEffectType, Integer> representation() throws EntityDeletedException;

    /**
     * This sets the level of a status effect for a given Character, ignoring resistances.
     *
     * @param type  The StatusEffectType
     * @param level The level to which to set the Status Effect
     * @throws EntityDeletedException   If this Character is deleted or dead
     * @throws IllegalArgumentException If and only if statusEffectTypeId is null, empty, or does
     *                                  not correspond to a valid StatusEffectType
     */
    void setStatusEffectLevel(StatusEffectType type, int level)
            throws EntityDeletedException, IllegalArgumentException;

    /**
     * Clears all Status Effects for this Character. (NB: This does not change whether the
     * Character is dead or deleted.)
     *
     * @throws EntityDeletedException If this Character is deleted or dead
     */
    void clearStatusEffects() throws EntityDeletedException;
}
