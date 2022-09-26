package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.CharacterStatusEffects;

/**
 * <b>CharacterStatusEffectsFactory</b>
 * <p>
 * This class creates a {@link CharacterStatusEffects} for a given {@link Character}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface CharacterStatusEffectsFactory extends SoliloquyClass {
    /**
     * @param character The {@link Character} for whom this {@link CharacterStatusEffects} is
     *                  to be made
     * @return The new {@link CharacterStatusEffects} for the provided character
     * @throws IllegalArgumentException If and only if character is null
     */
    CharacterStatusEffects make(Character character) throws IllegalArgumentException;
}
