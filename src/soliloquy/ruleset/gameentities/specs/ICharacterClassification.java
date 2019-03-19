package soliloquy.ruleset.gameentities.specs;

import soliloquy.common.specs.IHasPluralName;

/**
 * <b>CharacterClassification</b>
 * <p>
 * A CharacterClassification is a type which applies to a given Character Type. So, for example,
 * Skeletons will have a CharacterClassification of Undead. Character Types can have multiple
 * CharacterClassifications.
 * <p>
 * CharacterClassifications have plural names, e.g. the CharacterClassification "Giant" will have
 * the plural name "Giants"
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ICharacterClassification extends IGameEntity, IHasPluralName {
}
