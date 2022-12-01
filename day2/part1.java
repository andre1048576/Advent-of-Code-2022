package day2;
import java.util.ArrayList;
import java.util.Iterator;

import common.Grid;
import common.GridInteger;
import common.InputReader;
public class part1 {
    static int day_number = 2;
    public static void main(String[] args) throws Exception  {
        ArrayList<String> lines = InputReader.get_input(day_number);
        if (!part2.class.getPackage().getName().equals("day"+Integer.toString(day_number))) {
            throw new Exception("WRONG DAY_NUMBER ENTERED ABORTING");
        }
        Grid<Integer> grid = new GridInteger(lines);
        solve(grid);
    }

    public static void solve(Grid<Integer> grid) {
        Iterator<Integer> iter = grid.get_adjacent_iterable(2, 0);
        Integer item = null;
        int sum = 0;
        while (iter.hasNext()) {
            item = iter.next();
            sum+=item;
        }
        System.out.println(sum);
    }
}

