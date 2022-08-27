package soliloquy.specs.graphics.renderables;

import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;

/**
 * <b>AntialiasedLineSegmentRenderable</b>
 * <p>
 * An antialiased (i.e. smooth) line segment which can be rendered in the window
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface AntialiasedLineSegmentRenderable extends LineSegmentRenderable {
    /**
     * @return A ProviderAtTime which provides the thickness of this line segment, <i>expressed in a
     *         percentage of the window width</i>, for a given timestamp. <i>It is expected that the
     *         value provided will never be null.</i>
     */
    ProviderAtTime<Float> getThicknessProvider();

    /**
     * @return A Provider which provides the percentage of the line segment's thickness which should
     *         be made of a gradient from its color to transparent
     */
    ProviderAtTime<Float> getThicknessGradientPercentProvider();

    void setThicknessGradientPercentProvider(
            ProviderAtTime<Float> thicknessGradientPercentProvider)
            throws IllegalArgumentException;

    ProviderAtTime<Float> getLengthGradientPercentProvider();

    void setLengthGradientPercentProvider(ProviderAtTime<Float> lengthGradientPercentProvider)
            throws IllegalArgumentException;
}
