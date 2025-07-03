package soliloquy.specs.ui.definitions.providers;

public class StaticProviderDefinition<T> extends AbstractProviderDefinition<T> {
    public final T VALUE;

    private StaticProviderDefinition(T value) {
        VALUE = value;
    }

    public static <T> StaticProviderDefinition<T> staticVal(T value) {
        return new StaticProviderDefinition<>(value);
    }
}
