package soliloquy.specs.common.valueobjects;

import java.util.Objects;

import static soliloquy.specs.common.valueobjects.Coordinate3d.coordinate3dOf;

/**
 * <b>Coordinate</b>
 * <p>
 * This object has both an x and a y value.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public class Coordinate2d {
    public final int X;
    public final int Y;

    private Coordinate2d(int x, int y) {
        X = x;
        Y = y;
    }

    public static Coordinate2d coordinate2dOf(int x, int y) {
        return new Coordinate2d(x, y);
    }

    public Coordinate3d to3d (int z) {
        return coordinate3dOf(X, Y, z);
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", X, Y);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Coordinate2d coordinate2d) {
            return coordinate2d.X == X && coordinate2d.Y == Y;
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }
}
