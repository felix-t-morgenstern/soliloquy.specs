package soliloquy.specs.gamestate.entities.exceptions;

/**
 * <b>SoliloquyIOException</b>
 * <p>
 * This exception serves as a RuntimeException specific to entities being deleted.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public class EntityDeletedException extends UnsupportedOperationException {
    public EntityDeletedException(String message) {
        super(message);
    }

    public EntityDeletedException(Exception e) {
        super(e);
    }
}
