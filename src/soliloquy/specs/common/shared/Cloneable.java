package soliloquy.specs.common.shared;

/**
 * <b>Cloneable</b>
 * <p>
 * This designates a class which can be cloned.
 * <p>
 * When a class is cloned, a deep clone should be returned.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <T> The same class which implements this interface.
 * <p>
 * <i>It is possible to implement this interface by setting this type parameter to any Cloneable
 * object, but that is heavily discouraged.</i>
 */
public interface Cloneable<T extends Cloneable<T>> extends SoliloquyClass {
	/**
	 * @return A deep (i.e. genuine) clone of this object.
	 */
	T makeClone();
}
