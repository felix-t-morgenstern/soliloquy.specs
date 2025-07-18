package soliloquy.specs.ui.definitions.content;

/**
 * <b>ContentDefinition</b>
 * <p>
 * This interface exists solely to enforce strict typing on members of
 * {@link AbstractComponentDefinition#content}.
 * <p>
 * (I could have, of course, made individual fluent interface implementations inherit shared methods
 * and properties, with generic parameters, allowing child methods to return child types, but that
 * felt like an excess of files to avoid duplicating a small handful of easily-legible lines of
 * code. If any observers are concluding that this is proof positive of the shortcomings of
 * object-oriented brainrot, they are of course correct, and are welcome to rewrite this engine in
 * LISP.)
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public abstract class AbstractContentDefinition {
    public final int Z;

    protected AbstractContentDefinition(int z) {
        Z = z;
    }
}
