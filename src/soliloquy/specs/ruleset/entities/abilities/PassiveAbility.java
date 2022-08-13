package soliloquy.specs.ruleset.entities.abilities;

/**
 * <b>PassiveAbility</b>
 * <p>
 * A Passive Ability belongs only to an {@link soliloquy.specs.gamestate.entities.Item}. (For
 * {@link soliloquy.specs.gamestate.entities.Character}s, the equivalent of a passive ability would
 * be represented through a {@link soliloquy.specs.gamestate.entities.CharacterStatistic}, a
 * {@link soliloquy.specs.gamestate.entities.CharacterStatusEffects}, or that Character's data.
 * <p>
 * It can generate a description for a specific PassiveAbility, depending on the parameters of
 * its effectiveness.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface PassiveAbility extends Ability {
}
