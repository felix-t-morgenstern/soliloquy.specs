package soliloquy.specs.ruleset.entities.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.ruleset.definitions.WallSegmentTypeDefinition;
import soliloquy.specs.ruleset.entities.WallSegmentType;

/**
 * <b>WallSegmentTypeFactory</b>
 * <p>
 * Creates {@link WallSegmentType}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface WallSegmentTypeFactory extends SoliloquyClass {
    /**
     * @param definition The definition of the WallSegmentType to create
     * @return The created WallSegmentType
     * @throws IllegalArgumentException If and only if definition is null; definition.id is null or
     *                                  empty; or definition.name is null or empty; or
     *                                  definition.imageAssetType is UNKNOWN or ANIMATION; or
     *                                  definition.imageAssetSetId is null, empty, or does not
     *                                  correspond to a valid
     *                                  {@link soliloquy.specs.graphics.assets.ImageAsset}
     */
    WallSegmentType make(WallSegmentTypeDefinition definition) throws IllegalArgumentException;
}
