package soliloquy.specs.graphics.renderables.providers;

/**
 * <b>StaticProvider</b>
 * <p>
 * A ProviderAtTime which provides a single value, irrespective of time
 * <p>
 * <i>NB: This class does not need to be explicitly defined to actually provide the values;
 * however, it is necessary to specify that this class is static, so its persistence can be
 * managed.</i>
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface StaticProvider<T> extends ProviderAtTime<T> {
}
