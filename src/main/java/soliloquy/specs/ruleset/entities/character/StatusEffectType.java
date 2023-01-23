package soliloquy.specs.ruleset.entities.character;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.HasName;
import soliloquy.specs.ruleset.entities.IconForCharacter;
import soliloquy.specs.ruleset.entities.actonroundendandcharacterturn.EffectsCharacterOnRoundOrTurnChange;

/**
 * <b>StatusEffectType</b>
 * <p>
 * A type of status effect, e.g. regenerating, poisoned, adrenaline rush, etc.
 * <p>
 * It has behaviors which can be performed on each Character at the start or end of their turn or
 * the round, e.g. regeneration, taking damage from poison, spilling blood on the ground, etc.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface StatusEffectType
        extends EffectsCharacterOnRoundOrTurnChange, IconForCharacter, HasName, HasId {
    /**
     * Intended use is to return true if and only if it makes no sense for this StatusEffectType to
     * ever go below zero. For instance, it makes no sense to have a negative amount of poisoning
     * or disease.
     *
     * @return True, if and only if this StatusEffectType cannot be negative.
     */
    boolean stopsAtZero();

    /**
     * Intended use is to return the correct name for a Status Effect, depending on its value. For
     * instance, a StatusEffectType of "Focus" might allow negative values to represent a Character
     * being distracted. In that case, nameAtValue(-5) might return "Distracted", whereas
     * nameAtValue(5) might return "Alert", nameAtValue(10) might return "Highly Alert", etc.
     *
     * @param value The value of this StatusEffect whose name to retrieve
     * @return The proper name for the StatusEffectType, depending on its value (e.g. whether it is
     *         non-negative)
     * @throws UnsupportedOperationException If and only if this StatusEffectType cannot be
     *                                       negative (i.e. if and only if stopsAtZero returns
     *                                       true)
     */
    String nameAtValue(int value) throws UnsupportedOperationException;
}
