package soliloquy.gamestate.specs;

import soliloquy.common.specs.IMap;

/**
 * <b>KeyBindingContexts</b>
 * <p>
 * It is a numbered Map, each of whose member is a KeyBindingContext. (The Id of this Map is the priority of the corresponding KeyBindingContext.)
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface IKeyBindingContexts extends IMap<Integer,IKeyBindingContext> {
}
