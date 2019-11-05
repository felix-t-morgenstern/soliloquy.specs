package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.shared.HasId;

/**
 * <b>CharacterStatisticType</b>
 * <p>
 * A type of statistic (e.g. characterStatisticTypes, aptitudes, etc.) which can be possessed by a Character.
 * <p>
 * It has a description, and a SpriteSet for graphical depictions
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface CharacterStatisticType extends HasId, HasDescription, HasSpriteSet {
}
