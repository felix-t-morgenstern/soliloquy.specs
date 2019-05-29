package soliloquy.common.specs;

/**
 * <b>Setting</b>
 * <p>
 * This is a Setting (e.g. for the Game, for graphics, for audio, etc.)
 * <p>
 * <i>Note: Setting should NOT display its parameter in getParameterizedClassName;
 * PersistentSettingHandler is intended to gather the type of its value from its getArchetype!</i>
 * 
 * @author felix.t.morgenstern
 *
 * @param <T> The type of this Setting
 */
public interface ISetting<T> extends IHasId, IHasName, IHasOneGenericParam<T> {
	/**
	 * @return The current value of this Setting
	 */
	T getValue();
	
	/**
	 * @param value - The value to which to set this Setting
	 * @throws IllegalArgumentException If the value is illegal (e.g. out of range, empty, etc.)
	 */
	void setValue(T value) throws IllegalArgumentException;
	
	/**
	 * @return Parameters determining how the control for this setting appears in the UI (e.g.
	 * whether it is a slider, a text field, etc.; whether it is hidden; etc.)
	 */
	IGenericParamsSet controlParams();
}
