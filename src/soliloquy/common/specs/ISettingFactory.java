package soliloquy.common.specs;

/**
 * 
 * @author felix.t.morgenstern
 *
 */
public interface ISettingFactory extends ISoliloquyClass {
	<T> ISetting<T> make(String id, String name, T defaultValue, IGenericParamsSet controlParams);
}
