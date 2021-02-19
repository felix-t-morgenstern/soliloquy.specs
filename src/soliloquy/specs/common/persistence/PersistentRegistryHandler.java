package soliloquy.specs.common.persistence;

import soliloquy.specs.common.infrastructure.Registry;

public interface PersistentRegistryHandler extends PersistentValueTypeHandler<Registry> {
    /**
     * @param valueType - Interface names with fully qualified generic types
     * @return A Registry, to be used as an archetype
     * @throws IllegalArgumentException If and only if valueType is null, empty, or one of its
     * specified types is not a valid type
     */
    Registry generateArchetype(String valueType) throws IllegalArgumentException;
}
