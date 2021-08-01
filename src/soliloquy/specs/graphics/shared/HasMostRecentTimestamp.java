package soliloquy.specs.graphics.shared;

import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>HasMostRecentTimestamp</b>
 * <p>
 * This class has a most recent timestamp at which rendering has occurred, to be used by
 * {@link soliloquy.specs.graphics.renderables.Renderable} and
 * {@link soliloquy.specs.graphics.rendering.renderers.Renderer} alike. This information is exposed
 * to facilitate persistence.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface HasMostRecentTimestamp extends SoliloquyClass {
    /**
     * @return The most recent timestamp at which rendering has occurred; if rendering has not
     * occurred, this method returns null.
     */
    Long mostRecentTimestamp();
}
