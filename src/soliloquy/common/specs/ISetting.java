package soliloquy.common.specs;

import java.lang.reflect.Type;

/**
 * <b>Setting</b>
 * <p>
 * This is a Setting (e.g. for the Game, for graphics, for audio, etc.)
 * 
 * @author felix.t.morgenstern
 *
 * @param <V> The type of this Setting
 */
public interface ISetting<V> extends IHasId, IHasName, IHasOneGenericParam<V> {
	/**
	 * @return The current value of this Setting
	 */
	V getValue();
	
	/**
	 * @param value - The value to which to set this Setting
	 * @throws IllegalArgumentException If the value is illegal (e.g. out of range, empty, etc.)
	 */
	void setValue(V value) throws IllegalArgumentException;
	
	/**
	 * @return The type of this Setting (e.g. boolean, String, etc.)
	 */
	Type getSettingType();
	
	/**
	 * @return Parameters determining how the control for this setting appears in the UI (e.g. whether it is a slider, a text field, etc.; whether it is hidden; etc.)
	 */
	IGenericParamsSet controlParams();
}
