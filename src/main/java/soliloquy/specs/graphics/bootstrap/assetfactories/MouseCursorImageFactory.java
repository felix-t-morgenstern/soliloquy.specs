package soliloquy.specs.graphics.bootstrap.assetfactories;

import soliloquy.specs.graphics.bootstrap.assetfactories.definitions.MouseCursorImageDefinition;

/**
 * <b>ImageFactory</b>
 * <p>
 * Creates mouse cursor images
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface MouseCursorImageFactory {
    /**
     * @param definition The definition of the mouse cursor image to create
     * @return The Id of the mouse cursor image loaded into the GPU
     * @throws IllegalArgumentException If and only if definition is null, its relative location is
     *                                  null or empty, or either its x or y hotspot is less than 0.
     */
    Output make(MouseCursorImageDefinition definition) throws IllegalArgumentException;

    class Output {
        private final String RELATIVE_LOCATION;
        private final long ID;

        public Output(String relativeLocation, long id) {
            RELATIVE_LOCATION = relativeLocation;
            ID = id;
        }

        public String relativeLocation() {
            return RELATIVE_LOCATION;
        }

        public long id() {
            return ID;
        }
    }
}
