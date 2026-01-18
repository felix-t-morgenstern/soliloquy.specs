package soliloquy.specs.common.valueobjects;

import static soliloquy.specs.common.valueobjects.Vertex.vertexOf;

/**
 * <b>FloatBox</b>
 * <p>
 * An object which represents some area in the window, where the horizontal and vertical limits of
 * the window are [-1.0,1.0]. (Bounding boxes which extend beyond the window's limits are not
 * illegal, but if none of a {@link soliloquy.specs.io.graphics.renderables.Renderable}'s bounding
 * box
 * is within the window, it may not be rendered.)
 * <p>
 * (NB: FloatBoxes are immutable, making it safe to pass them around freely.)
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public class FloatBox {
    public final float LEFT_X;
    public final float TOP_Y;
    public final float RIGHT_X;
    public final float BOTTOM_Y;

    private FloatBox(float leftX, float topY, float rightX, float bottomY) {
        LEFT_X = leftX;
        TOP_Y = topY;
        RIGHT_X = rightX;
        BOTTOM_Y = bottomY;
    }

    public static FloatBox floatBoxOf(float leftX, float topY, float rightX, float bottomY) {
        return new FloatBox(leftX, topY, rightX, bottomY);
    }

    /**
     * This method is intended as a measure of convenience for instances where a box' dimensions are
     * needed, but its location on-screen is irrelevant, i.e., for Component layout
     */
    public static FloatBox floatBoxOf(float width, float height) {
        return new FloatBox(0f, 0f, width, height);
    }

    public static FloatBox floatBoxOf(Vertex topLeft, Vertex bottomRight) {
        return new FloatBox(topLeft.X, topLeft.Y, bottomRight.X, bottomRight.Y);
    }

    public static FloatBox floatBoxOf(Vertex topLeft, float width, float height) {
        return new FloatBox(topLeft.X, topLeft.Y, topLeft.X + width, topLeft.Y + height);
    }

    public float width() {
        return RIGHT_X - LEFT_X;
    }

    public float height() {
        return BOTTOM_Y - TOP_Y;
    }

    public Vertex topLeft() {
        return vertexOf(LEFT_X, TOP_Y);
    }

    public Vertex topRight() {
        return vertexOf(RIGHT_X, TOP_Y);
    }

    public Vertex bottomLeft() {
        return vertexOf(LEFT_X, BOTTOM_Y);
    }

    public Vertex bottomRight() {
        return vertexOf(RIGHT_X, BOTTOM_Y);
    }

    @Override
    public String toString() {
        return String.format("[[%s,%s],[%s,%s]]", LEFT_X, TOP_Y, RIGHT_X, BOTTOM_Y);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof FloatBox f) {
            return f.LEFT_X == LEFT_X && f.TOP_Y == TOP_Y &&
                    f.RIGHT_X == RIGHT_X && f.BOTTOM_Y == BOTTOM_Y;
        }
        else {
            return false;
        }
    }
}
