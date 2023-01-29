package soliloquy.specs.gamestate.entities;

import soliloquy.specs.gamestate.entities.exceptions.EntityDeletedException;
import soliloquy.specs.gamestate.entities.gameevents.GameCharacterEvent;

import java.util.List;
import java.util.Map;

/**
 * <b>CharacterEvents</b>
 * <p>
 * This class manages the events for a given {@link Character}. A trigger of a given name (e.g.
 * "onDeath", "onAttack", "onMove", etc.) can trigger any number of associated
 * {@link GameCharacterEvent}s to fire, and those associations are managed by this class. (A given
 * event may be triggered by events of more than one type.)
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface CharacterEvents extends Deletable {
    /**
     * @param triggers The names of the event triggers to trigger the added event
     * @param event    The event to trigger on the firing of an event of the specified trigger
     * @throws IllegalArgumentException If and only if triggers is null or contains any null or
     *                                  empty items, or if event is null
     * @throws EntityDeletedException   If and only if the {@link Character} corresponding to this
     *                                  class is deleted
     */
    void addEvent(String[] triggers, GameCharacterEvent event)
            throws IllegalArgumentException, EntityDeletedException;

    /**
     * @param event   The event which will no longer be associated with the specified trigger
     * @return True, if and only if the specified event had previously been associated with the
     *         specified trigger type
     * @throws IllegalArgumentException If and only if event is null
     * @throws EntityDeletedException   If and only if the {@link Character} corresponding to this
     *                                  class is deleted
     */
    boolean removeEvent(GameCharacterEvent event)
            throws IllegalArgumentException, EntityDeletedException;

    /**
     * @param trigger The type of event whose corresponding events will no longer be triggered for
     *                this {@link Character}. If an event loses its last trigger, it will be
     *                deleted from this class.
     * @throws IllegalArgumentException If and only if trigger is null or empty
     * @throws EntityDeletedException   If and only if the {@link Character} corresponding to this
     *                                  class is deleted
     */
    void clearTrigger(String trigger) throws IllegalArgumentException, EntityDeletedException;

    /**
     * Clears all events for all trigger types for this {@link Character}
     *
     * @throws EntityDeletedException If and only if the {@link Character} corresponding to this
     *                                class is deleted
     */
    void clearAllEvents() throws EntityDeletedException;

    /**
     * @param events The events to copy into this class
     * @throws IllegalArgumentException If and only if events is null
     * @throws EntityDeletedException If and only if the {@link Character} corresponding to this
     *                                class is deleted
     */
    void copyAllTriggers(CharacterEvents events) throws IllegalArgumentException, EntityDeletedException;

    /**
     * Fires all events for this {@link Character} which are associated with the specified trigger.
     * (This may result in no events being fired.)
     *
     * @param trigger The type of trigger whose corresponding events to fire
     * @throws IllegalArgumentException If and only if trigger is null or empty
     * @throws EntityDeletedException   If and only if the {@link Character} corresponding to this
     *                                  class is deleted
     */
    void fire(String trigger) throws IllegalArgumentException, EntityDeletedException;

    /**
     * @return A Map, whose indices are all triggers with at least one associated event, and whose
     *         values are Collections of all events associated with the corresponding triggers
     * @throws EntityDeletedException If and only if the {@link Character} corresponding to this
     *                                class is deleted
     */
    Map<String, List<GameCharacterEvent>> representation() throws EntityDeletedException;
}
