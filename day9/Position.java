package day9;

public class Position {
    
    int x;
    int y;
    Position(int x,int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o) {
        if (o.getClass() != this.getClass())
            return false;
        Position o_pos = (Position) o;
        return o_pos.x == this.x && o_pos.y == this.y;
    }

    public void add(int x,int y) {
        this.x+=x;
        this.y+=y;
    }

    public void add(Position p) {
        add(p.x,p.y);
    }

    public boolean adjacent(Position p) {
        return Math.abs(p.x - this.x) < 2 && Math.abs(p.y - this.y) < 2;
    }

    public void moveTowards(Position p) {
        if (adjacent(p)) 
            return;
        add(Integer.signum(p.x-x),Integer.signum(p.y-y));
    }
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
