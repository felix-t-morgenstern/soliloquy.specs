package soliloquy.specs.graphics.bootstrap.taskfactories;

import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.graphics.renderables.providers.factories.AnimatedMouseCursorProviderFactory;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * <b>AnimatedMouseCursorTaskFactory</b>
 * <p>
 * This class creates a Runnable which will load an AnimatedMouseCursor when preloading all
 * graphics (c.f. {@link soliloquy.specs.graphics.bootstrap.GraphicsPreloader})
 *
 * @param <TDefinitionDto> The DTO defining the AnimatedMouseCursor to be created
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface AnimatedMouseCursorTaskFactory<TDefinitionDto> {
    /**
     * @param getMouseCursorsByRelativeLocation A Function which returns a static mouse cursor Id
     *                                          (to be used per frame) for a given image's relative
     *                                          location
     * @param animatedMouseCursorDefinitionDTOs Definitions of the AnimatedMouseCursors to be
     *                                          created
     * @param factory Creates the AnimatedMouseCursors
     * @param processResult A function which processes each result as it is created
     * @return A Task, which, when run, will load some AnimatedMouseCursors
     * @throws IllegalArgumentException If and only if getMouseCursorsByRelativeLocation,
     * animatedMouseCursorDefinitionDTOs, factory, or processResult are null
     */
    Runnable make(Function<String, Long> getMouseCursorsByRelativeLocation,
                  Collection<TDefinitionDto> animatedMouseCursorDefinitionDTOs,
                  AnimatedMouseCursorProviderFactory factory,
                  Consumer<ProviderAtTime<Long>> processResult)
            throws IllegalArgumentException;
}
