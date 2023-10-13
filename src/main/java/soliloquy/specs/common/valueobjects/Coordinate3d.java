package soliloquy.specs.common.valueobjects;

import soliloquy.specs.common.shared.SoliloquyClass;

import java.util.Objects;

/**
 * <b>Coordinate</b>
 * <p>
 * This object has both an x and a y value.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public class Coordinate3d implements SoliloquyClass {
    public final int X;
    public final int Y;
    public final int Z;

    private Coordinate3d(int x, int y, int z) {
        X = x;
        Y = y;
        Z = z;
    }

    public static Coordinate3d of(int x, int y, int z) {
        return new Coordinate3d(x, y, z);
    }

    public static Coordinate3d of(Coordinate2d coordinate2d, int z) {
        return new Coordinate3d(coordinate2d.X, coordinate2d.Y, z);
    }

    public Coordinate2d to2d() {
        return Coordinate2d.of(X, Y);
    }

    @Override
    public String getInterfaceName() {
        return Coordinate3d.class.getCanonicalName();
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
