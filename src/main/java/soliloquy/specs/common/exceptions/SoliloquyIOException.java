package soliloquy.specs.common.exceptions;

/**
 * <b>SoliloquyIOException</b>
 * <p>
 * This exception serves as a RuntimeException wrapped around an {@link java.io.IOException}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public class SoliloquyIOException extends RuntimeException {
    public SoliloquyIOException(Exception e) {
        super(e);
    }
}
