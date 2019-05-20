package soliloquy.gamestate.specs;

import soliloquy.common.specs.ISoliloquyClass;

/**
 * <b>CharacterStatusEffectsFactory</b>
 * <p>
 * This class creates a {@link ICharacterStatusEffects} for a given {@link ICharacter}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ICharacterStatusEffectsFactory extends ISoliloquyClass {
    /**
     * @param character - The {@link ICharacter} for whom this {@link ICharacterStatusEffects} is
     *                  to be made
     * @return The new {@link ICharacterStatusEffects} for the provided character
     * @throws IllegalArgumentException If and only if character is null
     */
    ICharacterStatusEffects make(ICharacter character) throws IllegalArgumentException;
}
