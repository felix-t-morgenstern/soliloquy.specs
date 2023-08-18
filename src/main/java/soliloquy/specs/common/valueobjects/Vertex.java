package soliloquy.specs.common.valueobjects;

import java.util.Objects;

public class Vertex {
    public final float X;
    public final float Y;

    public Vertex(float x, float y) {
        X = x;
        Y = y;
    }

    public static Vertex of(float x, float y) {
        return new Vertex(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Vertex) {
            Vertex v = (Vertex)o;
            return v.X == X && v.Y == Y;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }
}
