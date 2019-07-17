package soliloquy.specs.ruleset.entities.abilities;

/**
 * <b>PassiveAbilityType</b>
 * <p>
 * It has an Id -- its Id identifies the effect it has, e.g. changing Attributes, Aptitudes, etc.
 * The individual PassiveAbilities specify *which* Attributes are changed, by how much, etc.)
 * <p>
 * It can generate a description for a specific PassiveAbilityType, depending on the parameters of
 * its effectiveness (e.g. those coming from an Item)
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface PassiveAbilityType extends AbilityType {
}
