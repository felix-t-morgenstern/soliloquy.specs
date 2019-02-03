package soliloquy.common.specs;

public interface ISettingFactory {
	<T> ISetting<T> make(String id, String name, T defaultValue, IGenericParamsSet controlParams);
}
