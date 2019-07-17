package soliloquy.specs.common.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.common.infrastructure.GenericParamsSet;

/**
 * <b>GenericParamsSetFactory</b>
 * <p>
 * Creates a new GenericParamsSetFactory
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface GenericParamsSetFactory extends SoliloquyClass {
	/**
	 * @return A new GenericParamsSet
	 */
	GenericParamsSet make();
}
