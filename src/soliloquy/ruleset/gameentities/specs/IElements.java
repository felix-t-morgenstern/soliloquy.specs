package soliloquy.ruleset.gameentities.specs;

import soliloquy.common.specs.IMap;
import soliloquy.common.specs.ISoliloquyClass;

/**
 * <b>Elements</b>
 * <p>
 * A named Map of all of the {@link IElement Element}s (e.g. fire, psychic, unblockable) which can be used to alter StatusEffects or VitalAttributes
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IElements extends IMap<String,IElement>, ISoliloquyClass {
}
