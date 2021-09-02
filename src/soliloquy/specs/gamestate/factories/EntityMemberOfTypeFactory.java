package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Deletable;
import soliloquy.specs.gamestate.entities.EntityMemberOfType;

/**
 * <b>EntityMemberOfTypeFactory</b>
 * <p>
 * Creates an entity member for a provided entity of a given type
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface EntityMemberOfTypeFactory<TEntityMemberType extends HasId,
        TEntityMember extends EntityMemberOfType<TEntityMemberType>,
        TEntity extends Deletable>
            extends SoliloquyClass {
    /**
     * <i>NB: This method creates a EntityMemberOfType without any data; to provide data, cf
     * {@link #make(Deletable, HasId, VariableCache)}</i>.
     * @param containingEntity The entity for whom to make the entity member
     * @param type The type of the entity member
     * @return The newly-created entity member of the provided type
     * @throws IllegalArgumentException If and only if containingEntity or type are null
     */
    TEntityMember make(TEntity containingEntity, TEntityMemberType type)
            throws IllegalArgumentException;
    /**
     * @param containingEntity The entity for whom to make the entity member
     * @param type The type of the entity member
     * @param data The data for the newly-created entity member
     * @return The newly-created entity member of the provided type
     * @throws IllegalArgumentException If and only if containingEntity, type, or data are null
     */
    TEntityMember make(TEntity containingEntity, TEntityMemberType type, VariableCache data)
            throws IllegalArgumentException;
}
