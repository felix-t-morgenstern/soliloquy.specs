package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.ReadableCollection;
import soliloquy.specs.common.infrastructure.ReadableMap;
import soliloquy.specs.gamestate.entities.gameevents.GameCharacterEvent;

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
     * @param trigger - The name of the event trigger to trigger the added event
     * @param event - The event to trigger on the firing of an event of the specified trigger
     * @throws IllegalArgumentException If and only if trigger is null or empty, or if event is
     * null
     * @throws IllegalStateException If and only if the {@link Character} corresponding to this
     * class is deleted
     */
    void addEvent(String trigger, GameCharacterEvent event)
            throws IllegalArgumentException, IllegalStateException;

    /**
     * @param trigger - The type of event whose corresponding events will no longer be triggered
     *                for this {@link Character}
     * @throws IllegalArgumentException If and only if trigger is null or empty
     * @throws IllegalStateException If and only if the {@link Character} corresponding to this
     * class is deleted
     */
    void clearEvent(String trigger) throws IllegalArgumentException, IllegalStateException;

    /**
     * Clears all events for all trigger types for this {@link Character}
     * @throws IllegalStateException If and only if the {@link Character} corresponding to this
     * class is deleted
     */
    void clearAllEvents() throws IllegalStateException;

    /**
     * @param event - The Event whose corresponding triggers to retrieve. (A given event may be
     *              triggered by multiple types of triggers.)
     * @return A Collection of all of the types of triggers which will trigger the specified event.
     * @throws IllegalArgumentException If and only if event is null
     * @throws IllegalStateException If and only if the {@link Character} corresponding to this
     * class is deleted
     */
    ReadableCollection<String> eventName(GameCharacterEvent event)
            throws IllegalArgumentException, IllegalStateException;

    /**
     * @param trigger - The name of the trigger for which the specified event will no longer be
     *                associated
     * @param event - The event which will no longer be associated with the specified trigger
     * @return True, if and only if the specified event had previously been associated with the
     * specified trigger type
     * @throws IllegalArgumentException If and only if trigger is null or empty, or if event is
     * null
     * @throws IllegalStateException If and only if the {@link Character} corresponding to this
     * class is deleted
     */
    boolean removeEvent(String trigger, GameCharacterEvent event)
            throws IllegalArgumentException, IllegalStateException;


    /**
     * @param trigger - The trigger type to check for any association with the specified event
     * @param event - The event to check for any association with the specified trigger type
     * @return True, if and only if the specified event is set to fire when a trigger of the
     * specified type occurs
     * @throws IllegalArgumentException If and only if trigger is null or empty, or if event is
     * null
     * @throws IllegalStateException If and only if the {@link Character} corresponding to this
     * class is deleted
     */
    boolean containsEvent(String trigger, GameCharacterEvent event)
        throws IllegalArgumentException, IllegalStateException;

    /**
     * Fires all events for this {@link Character} which are associated with the specified trigger.
     * (This may result in no events being fired.)
     * @param trigger - The type of trigger whose corresponding events to fire
     * @throws IllegalArgumentException If and only if trigger is null or empty
     * @throws IllegalStateException If and only if the {@link Character} corresponding to this
     * class is deleted
     */
    void fire(String trigger) throws IllegalArgumentException, IllegalStateException;

    /**
     * @return A Map, whose indices are all triggers with at least one associated event, and whose
     * values are Collections of all events associated with the corresponding triggers
     * @throws IllegalStateException If and only if the {@link Character} corresponding to this
     * class is deleted
     */
    ReadableMap<String, ReadableCollection<GameCharacterEvent>> representation()
            throws IllegalStateException;
}
