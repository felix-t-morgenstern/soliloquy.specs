package soliloquy.specs.common.factories;

import soliloquy.specs.common.infrastructure.Registry;
import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.SoliloquyClass;

public interface RegistryFactory extends SoliloquyClass {
    <T extends HasId> Registry<T> make(T archetype);
}
