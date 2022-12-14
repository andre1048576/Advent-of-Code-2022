package day12;
import java.util.ArrayList;
import java.util.Iterator;

import common.InputReader;
import common.Position;

import java.util.ArrayDeque;
public class part1 {
    static int day_number = 12;
    public static void main(String[] args) throws Exception  {
        ArrayList<String> lines = InputReader.get_input(day_number);
        if (!part1.class.getPackage().getName().equals("day"+Integer.toString(day_number))) {
            throw new Exception("WRONG DAY_NUMBER ENTERED ABORTING");
        }
        GridHeight grid = new GridHeight(lines);
        solve(grid);
    }

    public static boolean reachable_from(GridHeight grid,Position from, Position to) {
        return grid.get(from).charAt(0)+1 >= grid.get(to).charAt(0);
    }

    public static void solve(GridHeight grid) {
        //find the highest point
        ArrayList<Position> verified = new ArrayList<>();
        ArrayDeque<DistancePosition> verifying = new ArrayDeque<>();
        verifying.add(new DistancePosition(grid.start,0));
        
        found: 
        while (verifying.size() > 0) {
            DistancePosition current = verifying.removeFirst();
            if (verified.contains(current.pos))
                continue;
            Iterator<Position> adjacent = grid.get_adjacent_cross(current.pos);
            Position checking;
            while (adjacent.hasNext()) {
                checking = adjacent.next();
                if (verified.contains(checking))
                    continue;
                if (reachable_from(grid, current.pos, checking)) {
                    if (checking.equals(grid.end)) {
                        System.out.println(current.distance+1);
                        break found;
                    }
                    verifying.addLast(new DistancePosition(checking, current.distance+1));
                }
            }
            verified.add(current.pos);
        }
    }
}

