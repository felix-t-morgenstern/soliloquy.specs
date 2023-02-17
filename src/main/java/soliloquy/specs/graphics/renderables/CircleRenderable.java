package soliloquy.specs.graphics.renderables;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.common.valueobjects.Vertex;
import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;

import java.awt.*;

/**
 * <b>TriangleRenderable</b>
 * <p>
 * A circle which can be rendered in the window
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface CircleRenderable extends SoliloquyClass {
    /**
     * @return A Provider, which specifies the point in the screen at which the circle is centered
     */
    ProviderAtTime<Vertex> getCenterProvider();

    /**
     * @param centerProvider The new Provider for the center location of the circle
     * @throws IllegalArgumentException If and only if centerProvider is null
     */
    void setCenterProvider(ProviderAtTime<Vertex> centerProvider) throws IllegalArgumentException;

    /**
     * @return A Provider, which specifies the width of the circle, expressed in percentage of the
     *         screen <strong>width</strong>
     */
    ProviderAtTime<Float> getWidthProvider();

    /**
     * @param widthProvider The new Provider for the width of the circle
     * @throws IllegalArgumentException If and only if widthProvider is null
     */
    void setWidthProvider(ProviderAtTime<Float> widthProvider) throws IllegalArgumentException;

    /**
     * @return A Provider, which specifies the color of the circle at a given timestamp
     */
    ProviderAtTime<Color> getColorProvider();

    /**
     * @param colorProvider The new Provider which specifies the color of the circle
     * @throws IllegalArgumentException If and only if colorProvider is null
     */
    void setColorProvider(ProviderAtTime<Color> colorProvider) throws IllegalArgumentException;
}
