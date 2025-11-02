package soliloquy.specs.common.valueobjects;

import java.util.Objects;

public class Vertex {
    public final float X;
    public final float Y;

    private Vertex(float x, float y) {
        X = x;
        Y = y;
    }

    public static Vertex vertexOf(float x, float y) {
        return new Vertex(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Vertex v) {
            return v.X == X && v.Y == Y;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("(%s,%s)", X, Y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }
}
