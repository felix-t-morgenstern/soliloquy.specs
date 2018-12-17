package soliloquy.ruleset.gameentities.specs;

import soliloquy.common.specs.ICollection;
import soliloquy.common.specs.ISoliloquyClass;

/**
 * <b>Aptitudes</b>
 * <p>
 * A Collection of Aptitude Ids.
 * <p>
 * (CharacterAptitudes are either calculated algorithmically in a single instance, or are stored statically. See {@link soliloquy.gamestate.specs.ICharacterAptitudes} for more information.
 * 
 * @author felix.t.morgenstern
 *
 */
public interface IAptitudes extends ICollection<String>, ISoliloquyClass {
}
