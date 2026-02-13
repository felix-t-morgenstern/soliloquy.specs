package soliloquy.specs.common.entities;

import soliloquy.specs.common.shared.HasId;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Methods {
    public final Map<String,Runnable> RUNNABLES;
    public final Map<String,Supplier> SUPPLIERS;
    public final Map<String,Consumer> CONSUMERS;
    public final Map<String,BiConsumer> BICONSUMERS;
    public final Map<String,Function> FUNCTIONS;
    public final Map<String,BiFunction> BIFUNCTIONS;

    public Methods() {
        RUNNABLES = new HashMap<>();
        SUPPLIERS = new HashMap<>();
        CONSUMERS = new HashMap<>();
        BICONSUMERS = new HashMap<>();
        FUNCTIONS = new HashMap<>();
        BIFUNCTIONS = new HashMap<>();
    }

    public Methods(Set<Runnable> runnables,
                   Set<Supplier> suppliers,
                   Set<Consumer> consumers,
                   Set<BiConsumer> biConsumers,
                   Set<Function> functions,
                   Set<BiFunction> biFunctions) {
        RUNNABLES = mapFromEntries(runnables);
        SUPPLIERS = mapFromEntries(suppliers);
        CONSUMERS = mapFromEntries(consumers);
        BICONSUMERS = mapFromEntries(biConsumers);
        FUNCTIONS = mapFromEntries(functions);
        BIFUNCTIONS = mapFromEntries(biFunctions);
    }

    private static <T extends HasId> Map<String, T> mapFromEntries(Set<T> entries) {
        var map = new HashMap<String, T>();
        entries.forEach(e -> map.put(e.id(), e));
        return map;
    }

    public Methods concatenate(Methods addend) {
        RUNNABLES.putAll(addend.RUNNABLES);
        SUPPLIERS.putAll(addend.SUPPLIERS);
        CONSUMERS.putAll(addend.CONSUMERS);
        BICONSUMERS.putAll(addend.BICONSUMERS);
        FUNCTIONS.putAll(addend.FUNCTIONS);
        BIFUNCTIONS.putAll(addend.BIFUNCTIONS);

        return this;
    }
}
