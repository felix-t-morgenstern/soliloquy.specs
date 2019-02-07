package soliloquy.gamestate.specs;

import soliloquy.common.specs.IEntityUuid;
import soliloquy.common.specs.IMap;

/**
 * <b>Items</b>
 * <p>
 * This is a Set of all Items which exist in this GameZone. The index of this Set is the Items's Uuid.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IItems extends IMap<IEntityUuid,IItem> {
	IItem getByUuid(IEntityUuid uuid);
}
