package soliloquy.specs.common.factories;

import soliloquy.specs.common.shared.ISoliloquyClass;
import soliloquy.specs.common.infrastructure.IGenericParamsSet;

/**
 * <b>GenericParamsSetFactory</b>
 * <p>
 * Creates a new GenericParamsSetFactory
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IGenericParamsSetFactory extends ISoliloquyClass {
	/**
	 * @return A new GenericParamsSet
	 */
	IGenericParamsSet make();
}
