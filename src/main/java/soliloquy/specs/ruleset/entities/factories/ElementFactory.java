package soliloquy.specs.ruleset.entities.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.ruleset.definitions.ElementDefinition;
import soliloquy.specs.ruleset.entities.Element;

public interface ElementFactory extends SoliloquyClass {
    /**
     * @param definition The definition of the Element to create
     * @return The created Element
     * @throws IllegalArgumentException If and only if definition is null; definition.id is null or
     *                                  empty; or definition.name is null or empty; or
     *                                  definition.imageAssetSetId is null, empty, or does not
     *                                  correspond to a valid
     *                                  {@link soliloquy.specs.graphics.assets.ImageAssetSet}
     */
    Element make(ElementDefinition definition) throws IllegalArgumentException;
}
