package soliloquy.specs.gamestate.entities.gameevents;

import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>GameEventFiring</b>
 * <p>
 * This class manages the execution of frames, as well as frame-blocking events.
 * <p>
 * <i>It is expected that this class will fire off every event it receives, in the order of their
 * priority. If two events are registered with the same priority, the event registered first will
 * fire first. It is also expected that when any events are firing, this class will generate a UUID
 * to place a block on saving the game via
 * {@link soliloquy.specs.gamestate.infrastructure.GameSaveBlocker#placeEventFiringBlock}.</i>
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface GameEventFiring extends SoliloquyClass {
    /**
     * When an event is registered with this method, the expectation is that it will be fired as
     * soon as no other events are being fired, and there are no events with a higher priority in
     * the queue.
     *
     * @param event    The event to register for firing next
     * @param priority The priority of the event. Higher values imply higher priority.
     * @throws IllegalArgumentException If and only if event is null
     */
    void registerEvent(Runnable event, int priority) throws IllegalArgumentException;

    /**
     * <i>NB: The intent for this method is to be used by a class in the UI to determine whether to
     * give the player gameplay control.</i>
     *
     * @return True, if and only if the Game is open to gameplay inputs, e.g. player characters
     *         moving or using abilities. This is only the case when there is no GameEvent currently
     *         firing, and no GameEvent in the queue.
     */
    boolean freeForGameplayInput();
}
