package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.sprites.entities.SpriteSet;

/**
 * <b>HasSpriteSet</b>
 * <p>
 * This class has a {@link SpriteSet}, which can be altered.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface HasSpriteSet extends SoliloquyClass {
    /**
     * Intended use for this SpriteSet is for any icons or pictures associated with this entity.
     * @return The SpriteSet for this entity (can be null)
     */
    SpriteSet getSpriteSet();

    /**
     * Intended use for this SpriteSet is for any icons or pictures associated with this entity.
     * @param spriteSet - The SpriteSet to set for this entity (can be null)
     */
    void setSpriteSet(SpriteSet spriteSet);
}
