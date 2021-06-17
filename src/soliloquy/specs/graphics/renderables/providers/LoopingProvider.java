package soliloquy.specs.graphics.renderables.providers;

import soliloquy.specs.common.shared.HasPeriodModuloOffset;

/**
 * <b>LoopingProvider</b>
 * <p>
 * This class is a {@link ProviderAtTime} which loops over values over time.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface LoopingProvider<T> extends ProviderAtTime<T>, HasPeriodModuloOffset {
}
