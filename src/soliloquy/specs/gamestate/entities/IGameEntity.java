package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.valueobjects.IGenericParamsSet;
import soliloquy.specs.common.shared.IHasName;

/**
 * <b>GameEntity</b>
 * <p>
 * Specifies common properties for entities that exist in the GameWorld.
 * <p>
 * All entities that exist in the GameWorld have a String Id and a name. They can be read from a
 * file and written to a file.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IGameEntity extends IHasName, IDeletable {
	/**
	 * @return Any parameters regarding this entity which do not fit neatly into any of their other
	 * properties.
	 * @throws IllegalStateException If this Item has been deleted
	 */
	IGenericParamsSet data() throws IllegalStateException;
}
