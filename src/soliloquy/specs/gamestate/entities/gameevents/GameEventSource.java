package soliloquy.specs.gamestate.entities.gameevents;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.ruleset.entities.abilities.AbilitySource;

/**
 * <b>GameEventSource</b>
 * <p>
 * This class describes the source of a {@link GameEvent}, which may be a {@link Character} or an
 * {@link AbilitySource}.
 * <p>
 * It is intended that this interface will be implemented as an anonymous class by the code firing
 * a {@link GameEvent}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface GameEventSource extends SoliloquyClass {
    /**
     * @return The {@link Character} to have triggered a {@link GameEvent}. If this is null, then
     * the event was not triggered by a Character.
     */
    Character character();

    /**
     * @return The {@link AbilitySource} to have triggered a {@link GameEvent}. If this is null,
     * then the event was not triggered by an Ability.
     */
    AbilitySource abilitySource();
}
