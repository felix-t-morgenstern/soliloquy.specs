package soliloquy.specs.ui.definitions.providers;

import java.util.Map;
import java.util.UUID;

public class FunctionalProviderDefinition<T> extends AbstractProviderDefinition<T> {
    public final String PROVIDE_FUNCTION_ID;

    public UUID uuid;
    public String pauseConsumerId;
    public String unpauseConsumerId;
    public Long pauseTimestamp;
    public Map<String, Object> data;

    private FunctionalProviderDefinition(String provideFunctionId) {
        PROVIDE_FUNCTION_ID = provideFunctionId;
    }

    public static <T> FunctionalProviderDefinition<T> functionalProvider(String provideFunctionId,
                                                                         Class<T> providedType) {
        return new FunctionalProviderDefinition<>(provideFunctionId);
    }

    public FunctionalProviderDefinition<T> withUuid(UUID uuid) {
        this.uuid = uuid;

        return this;
    }

    public FunctionalProviderDefinition<T> withPauseActions(String pauseConsumerId,
                                                            String unpauseConsumerId) {
        this.pauseConsumerId = pauseConsumerId;
        this.unpauseConsumerId = unpauseConsumerId;

        return this;
    }

    public FunctionalProviderDefinition<T> withPauseTimestamp(Long pauseTimestamp) {
        this.pauseTimestamp = pauseTimestamp;

        return this;
    }

    public FunctionalProviderDefinition<T> withData(Map<String, Object> data) {
        this.data = data;

        return this;
    }
}
