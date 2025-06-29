package soliloquy.specs.common.valueobjects;

import java.util.Objects;

import static soliloquy.specs.common.valueobjects.Coordinate2d.coordinate2dOf;

/**
 * <b>Coordinate3d</b>
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public class Coordinate3d {
    public final int X;
    public final int Y;
    public final int Z;

    private Coordinate3d(int x, int y, int z) {
        X = x;
        Y = y;
        Z = z;
    }

    public static Coordinate3d coordinate3dOf(int x, int y, int z) {
        return new Coordinate3d(x, y, z);
    }

    public static Coordinate3d coordinate3dOf(Coordinate2d coordinate2d, int z) {
        return new Coordinate3d(coordinate2d.X, coordinate2d.Y, z);
    }

    public Coordinate2d to2d() {
        return coordinate2dOf(X, Y);
    }

    @Override
    public String toString() {
        return String.format("(%d,%d,%d)", X, Y, Z);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Coordinate3d coordinate3d) {
            return coordinate3d.X == X && coordinate3d.Y == Y && coordinate3d.Z == Z;
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y, Z);
    }
}
