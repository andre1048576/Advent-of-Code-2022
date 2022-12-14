package day12;
import java.util.ArrayList;
import java.util.Iterator;

import common.GridString;
import common.Position;

public class GridHeight extends GridString {
    Position start;
    Position end;
    int searching_for = 2;
    ArrayList<Position> potential_starts = new ArrayList<>();
    public GridHeight(ArrayList<String> lines) {
        super(lines);
        Iterator<Position> positions = get_all_indexes();
        Position p;
        while (positions.hasNext()) {
            p = positions.next();
            if (get(p).equals("S")) {
                start= new Position(p);
                searching_for-=1;
            } else if (get(p).equals("E")) {
                end = new Position(p);
                searching_for-=1;
            } else if (get(p).equals("a")) {
                potential_starts.add(new Position(p));
            }
            if (searching_for == 0) {
                replace(start, "a");
                replace(end,"z");
                break;
            }
        }
    }
    
}