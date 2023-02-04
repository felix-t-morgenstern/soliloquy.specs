package soliloquy.specs.ruleset.entities.abilities;

/**
 * <b>ActiveAbility</b>
 * <p>
 * It can be used on a target(s), given a source, and parameters regarding its effects
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ActiveAbility extends Ability {
    /**
     * This method is intended to be used by the UI to limit the types of entities which can be
     * highlighted and selected in the UI, and passed into the ActiveAbility.
     *
     * @return The types of targets which this ActiveAbility can take.
     */
    TargetType[] targetTypes();

    /**
     * Uses this ActiveAbility against some target(s)
     * <p>
     * This method is intended to calculate the potency of this Ability by looking up some
     * property(s) of the Character or Item, or some other attached params.
     *
     * @param source  The source of the ActiveAbility
     * @param targets The target(s) of the ActiveAbility
     * @throws IllegalArgumentException If and only if source is null, or any of the items in
     *                                  targets are null
     */
    void use(AbilitySource source, Object... targets) throws IllegalArgumentException;

    enum TargetType {
        TILE,
        CHARACTER,
        TILE_FIXTURE,
        WALL_SEGMENT
    }
}
