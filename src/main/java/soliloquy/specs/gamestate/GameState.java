package soliloquy.specs.gamestate;

import soliloquy.specs.gamestate.entities.*;
import soliloquy.specs.gamestate.entities.gameevents.GameAbilityEvent;
import soliloquy.specs.gamestate.entities.gameevents.GameMovementEvent;
import soliloquy.specs.gamestate.entities.shared.HasData;
import soliloquy.specs.gamestate.entities.timers.ClockBasedTimerManager;
import soliloquy.specs.gamestate.entities.timers.RoundBasedTimerManager;
import soliloquy.specs.gamestate.factories.*;
import soliloquy.specs.ruleset.entities.character.CharacterAIType;
import soliloquy.specs.ui.GameZoneView;

import java.util.Map;

import static soliloquy.specs.gamestate.entities.CharacterEvents.CharacterEvent;

/**
 * <b>GameState</b>
 * <p>
 * This is a representation of the GameState.
 * <p>
 * The GameState includes the Party, PersistentVariables, the current GameZone, round management,
 * and key bindings.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface GameState extends HasData {
    /**
     * @return The Party (i.e., the player's Characters)
     */
    Party party() throws IllegalStateException;

    /**
     * @return A Map of AIs which can be assigned to various characters
     */
    Map<String, CharacterAIType> characterAIs();

    /**
     * @return A repository which can retrieve GameZones
     */
    GameZoneRepo gameZoneRepo();

    /**
     * @return A dictionary of game events triggered by a Character moving onto a Tile
     */
    Map<String, GameMovementEvent> movementEvents();

    /**
     * @return A dictionary of game events triggered by a Character's or Item's Ability being used
     *         on a Tile
     */
    Map<String, GameAbilityEvent> abilityEvents();

    /**
     * @return A dictionary of events which can happen to a Character in response to incoming events
     */
    Map<String, CharacterEvent> characterEvents();

    /**
     * @return The RoundManager, i.e., the class which handles Characters' turns, Timers, and the
     *         advancement of rounds
     */
    RoundManager roundManager();

    /**
     * @return The RoundBasedTimerManager, i.e., the class which tracks
     *         {@link soliloquy.specs.gamestate.entities.timers.RoundBasedTimer}s, and fires them
     *         when specified.
     */
    RoundBasedTimerManager roundBasedTimerManager();

    /**
     * @return The ClockBasedTimerManager, i.e., the class which tracks
     *         {@link soliloquy.specs.gamestate.entities.timers.ClockBasedTimer}s, and fires them
     *         when specified.
     */
    ClockBasedTimerManager clockBasedTimerManager();

    /**
     * This class is used to create new Items
     */
    ItemFactory itemFactory();

    /**
     * This class is used to create new Characters
     */
    CharacterFactory characterFactory();

    /**
     * This class is used to create new RoundBasedTimers
     */
    RoundBasedTimerFactory roundBasedTimerFactory();
}
