package soliloquy.specs.game;

/**
 * <b>Module</b>
 * <p>
 * This class provides a broad suite of functionality needed for the {@link Game}, e.g., I/O,
 * Ruleset, Gamestate, etc. It provides instances of needed classes for other dependent Modules, as
 * well as for the Game itself.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface Module {
    /**
     * @param clazz The class to provide from the Module
     * @return A provided instance of that class
     * @throws IllegalArgumentException If and only if clazz is null
     */
    <T> T provide(Class<T> clazz) throws IllegalArgumentException;

    /**
     * @param instance The name of the instance to provide from the Module
     * @param <T>      The type to return
     * @return A provided instance with that name
     * @throws IllegalArgumentException If and only if instance is null or empty or does not
     *                                  correspond to any instance within this Module
     */
    <T> T provide(String instance) throws IllegalArgumentException;
}
