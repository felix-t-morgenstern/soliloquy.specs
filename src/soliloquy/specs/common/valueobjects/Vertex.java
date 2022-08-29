package soliloquy.specs.common.valueobjects;

public class Vertex {
    public float x;
    public float y;

    public Vertex(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public static Vertex of(float x, float y) {
        return new Vertex(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Vertex) {
            Vertex v = (Vertex)o;
            return v.x == x && v.y == y;
        } else {
            return false;
        }
    }
}
