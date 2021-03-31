package soliloquy.specs.graphics.assets;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.rendering.Renderer;

/**
 * <b>HasTextureId</b>
 * <p>
 * This interface is for classes which have a texture Id (i.e. {@link Font} and {@link Image})
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface HasTextureId extends SoliloquyClass {
    /**
     * @return The id of the corresponding texture, which can be used by {@link Renderer}s
     */
    int textureId();
}
