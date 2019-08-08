package soliloquy.specs.gamestate.entities.gameevents;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Tile;
import soliloquy.specs.gamestate.entities.TileFixture;

/**
 * <b>GameEventSource</b>
 * <p>
 * This class describes the source of a {@link GameEvent}, which may be a {@link Tile} or a
 * {@link TileFixture}.
 * <p>
 * It is intended that this interface will be implemented as an anonymous class by the code firing
 * a {@link GameEvent}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface GameEventTarget extends SoliloquyClass {
    /**
     * @return The {@link Tile} which is the target for this {@link GameEvent}.
     */
    Tile tile();

    /**
     *
     * @return The {@link TileFixture} which is the target for this {@link GameEvent}.
     */
    TileFixture tileFixture();
}
