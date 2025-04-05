package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.WallSegment;

public interface WallSegmentFactory extends SoliloquyClass {
    /**
     * @param definition The definition of the WallSegment to produce
     * @return A WallSegment created according to the definition
     * @throws IllegalArgumentException If and only if definition is null, or has a null or invalid
     *                                  typeId
     */
    WallSegment make(Definition definition) throws IllegalArgumentException;

    class Definition {
        public String typeId;
        public String[] movementEventIds;
        public String[] abilityEventIds;
        public String data;

        public Definition(String typeId, String[] movementEventIds, String[] abilityEventIds,
                          String data) {
            this.typeId = typeId;
            this.movementEventIds = movementEventIds;
            this.abilityEventIds = abilityEventIds;
            this.data = data;
        }
    }
}
