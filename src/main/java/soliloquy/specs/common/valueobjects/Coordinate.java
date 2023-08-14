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
public class Coordinate implements SoliloquyClass {
    private final int X;
    private final int Y;

    private Coordinate(int x, int y) {
        X = x;
        Y = y;
    }

    public static Coordinate of(int x, int y) {
        return new Coordinate(x, y);
    }

    public int x() {
        return X;
    }

    public int y() {
        return Y;
    }

    @Override
    public String getInterfaceName() {
        return Coordinate.class.getCanonicalName();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Coordinate) {
            Coordinate coordinate = (Coordinate) o;
            return coordinate.x() == X && coordinate.y() == Y;
        }
        else {
            return false;
        }
    }
}
