package soliloquy.common.specs;

/**
 * <b>PersistentVariableTypeCache</b>
 * <p>
 * A PersistentVariableTypeCache is a cache of variables (identified by String Ids) which are saved when the player quits the Game--presumably to a save file--and which are restored once that save file is loaded.
 * <p>
 * An individual PersistentVariableTypeCache is a cache for variables of a specific type, e.g. Integers, Strings, Booleans, etc.
 * <p>
 * A PersistentVariableTypeCache can be populated by reading lines from a String.
 * <p>
 * (The intended use is that either each line will correspond to a single variable, or that lines will describe variables in a systematic way, e.g. with each line defining an item in a Collection, after a first line describing that Collection.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <T> The type of variables held in this cache
 */
public interface IPersistentVariableTypeCache<T> extends IMap<String,T>, IReads, IWrites, IHasOneGenericParam<T> {
}
