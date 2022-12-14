package common;

public class Position {
    int x;
    int y;

    Position(int x,int y) {
        this.x = x;
        this.y = y;
    }

    public Position(Position p) {
        this(p.x,p.y);
    }

    public void add(Position other) {
        this.x+=other.x;
        this.y+=other.y;
    }

    public void add(int x,int y) {
        this.x+=x;
        this.y+=y;
    }

    public boolean equals(Object o) {
        if (o.getClass() != this.getClass())
            return false;
        Position o_pos = (Position) o;
        return o_pos.x == this.x && o_pos.y == this.y;
    }

    public String toString() {
        return "{" + x + " , " + y + "}";
    }
}
