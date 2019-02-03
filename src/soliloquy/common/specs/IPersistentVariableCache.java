package soliloquy.common.specs;

/**
 * <b>PersistentVariableCache</b>
 * <p>
 * A PersistentVariableCache is a cache of {@link soliloquy.common.specs.IPersistentVariable}s (identified by String Ids) which are saved when the player quits the Game--presumably to a save file--and which are restored once that save file is loaded.
 * <p>
 * An individual PersistentVariableCache is a cache for variables of any type. It is expected that developers will know the types to their own PersistentVariables, and will therefore be able to cast them properly.
 * <p>
 * A PersistentVariableCache can be populated by reading lines from a String.
 * <p>
 * (The intended use is that either each line will correspond to a single variable, or that lines will describe variables in a systematic way, e.g. with each line defining an item in a Collection, after a first line describing that Collection.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IPersistentVariableCache extends IMap<String,IPersistentVariable>, IReads, IWrites {	
	/**
	 * @param persistentVariable - The PersistentVariable to place in this cache
	 * @throws IllegalArgumentException If persistentVariable is null or invalid
	 */
	void put(IPersistentVariable persistentVariable) throws IllegalArgumentException;
}
