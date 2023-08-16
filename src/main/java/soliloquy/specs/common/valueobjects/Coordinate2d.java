package soliloquy.specs.common.valueobjects;

import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>Coordinate</b>
 * <p>
 * This object has both an x and a y value.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public class Coordinate2d implements SoliloquyClass {
    public final int X;
    public final int Y;

    private Coordinate2d(int x, int y) {
        X = x;
        Y = y;
    }

    public static Coordinate2d of(int x, int y) {
        return new Coordinate2d(x, y);
    }

    @Override
    public String getInterfaceName() {
        return Coordinate2d.class.getCanonicalName();
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
}
