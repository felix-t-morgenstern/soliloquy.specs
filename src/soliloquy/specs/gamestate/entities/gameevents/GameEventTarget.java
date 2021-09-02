package soliloquy.specs.gamestate.entities.gameevents;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Tile;
import soliloquy.specs.gamestate.entities.TileFixture;
import soliloquy.specs.gamestate.entities.TileWallSegment;

/**
 * <b>GameEventSource</b>
 * <p>
 * This class describes the target of a movement event, i.e. a {@link Tile} or {@link TileFixture}
 * into which some {@link soliloquy.specs.gamestate.entities.Character} is moving.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface GameEventTarget extends SoliloquyClass {
    /**
     * @return The {@link Tile} which is the target for this {@link GameMovementEvent}; may be
     * null.
     */
    Tile tile();

    /**
     * @return The {@link TileFixture} which is the target for this {@link GameMovementEvent}; may
     * be null.
     */
    TileFixture tileFixture();

    /**
     * @return The {@link TileWallSegment} which is the target for this {@link GameMovementEvent};
     * may be null.
     */
    TileWallSegment tileWallSegment();
}
