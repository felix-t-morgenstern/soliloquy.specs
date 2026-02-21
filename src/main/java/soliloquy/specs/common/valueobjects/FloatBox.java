package soliloquy.specs.common.valueobjects;

import soliloquy.specs.io.graphics.renderables.Renderable;

import java.util.HashSet;
import java.util.Set;

import static soliloquy.specs.common.valueobjects.Vertex.vertexOf;

/**
 * <b>FloatBox</b>
 * <p>
 * An object which represents some area in the window, where the horizontal and vertical limits of
 * the window are [-1.0,1.0]. (Bounding boxes which extend beyond the window's limits are not
 * illegal, but if none of a {@link Renderable}'s bounding
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

    public Float side(Side side) {
        return switch (side) {
            case LEFT -> LEFT_X;
            case TOP -> TOP_Y;
            case RIGHT -> RIGHT_X;
            case BOTTOM -> BOTTOM_Y;
        };
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
    
    public Vertex corner(Corner corner) {
        return switch (corner) {
            case TOP_LEFT -> topLeft();
            case TOP_RIGHT -> topRight();
            case BOTTOM_RIGHT -> bottomRight();
            case BOTTOM_LEFT -> bottomLeft();
        };
    }

    public Set<Vertex> corners() {
        return new HashSet<>() {{
            add(topLeft());
            add(topRight());
            add(bottomLeft());
            add(bottomRight());
        }};
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

    public enum Side {
        LEFT(1),
        TOP(2),
        RIGHT(3),
        BOTTOM(4);

        private final int VALUE;

        Side(int value) {
            VALUE = value;
        }

        public int getValue() {
            return VALUE;
        }

        public static Side fromValue(Integer value) {
            if (value == null) {
                return null;
            }
            return switch (value) {
                case 1 -> LEFT;
                case 2 -> TOP;
                case 3 -> RIGHT;
                case 4 -> BOTTOM;
                default -> throw new IllegalArgumentException("Side: value (" + value +
                        ") does not correspond to valid enum type");
            };
        }
    }

    public enum Corner {
        TOP_LEFT(1),
        TOP_RIGHT(2),
        BOTTOM_RIGHT(3),
        BOTTOM_LEFT(4);

        private final int VALUE;

        Corner(int value) {
            VALUE = value;
        }

        public int getValue() {
            return VALUE;
        }

        public static Corner fromValue(Integer value) {
            if (value == null) {
                return null;
            }
            return switch (value) {
                case 1 -> TOP_LEFT;
                case 2 -> TOP_RIGHT;
                case 3 -> BOTTOM_RIGHT;
                case 4 -> BOTTOM_LEFT;
                default -> throw new IllegalArgumentException("Corner: value (" + value +
                        ") does not correspond to valid enum type");
            };
        }
    }
}
