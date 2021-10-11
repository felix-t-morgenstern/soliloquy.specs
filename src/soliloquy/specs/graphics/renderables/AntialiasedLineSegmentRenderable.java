package soliloquy.specs.graphics.renderables;

import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;

/**
 * <b>AntialiasedLineSegmentRenderable</b>
 * <p>
 * An antialiased (i.e. smooth) line segment which can be rendered in the window
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface AntialiasedLineSegmentRenderable extends LineSegmentRenderable {
    /**
     * @return A Provider which provides the percentage of the line segment's thickness which should be
     */
    ProviderAtTime<Float> thicknessGradientPercentProvider();

    void setThicknessGradientPercentProvider(
            ProviderAtTime<Float> thicknessGradientPercentProvider)
            throws IllegalArgumentException;

    ProviderAtTime<Float> lengthGradientPercentProvider();

    void setLengthGradientPercentProvider(ProviderAtTime<Float> lengthGradientPercentProvider)
            throws IllegalArgumentException;
}
