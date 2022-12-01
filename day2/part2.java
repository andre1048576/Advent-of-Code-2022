package day2;
import java.util.ArrayList;
import java.util.Iterator;
import common.GridString;
import common.InputReader;
public class part2 {
    static int day_number = 2;
    public static void main(String[] args) throws Exception  {
        ArrayList<String> lines = InputReader.get_input(day_number);
        if (!part2.class.getPackage().getName().equals("day"+Integer.toString(day_number))) {
            throw new Exception("WRONG DAY_NUMBER ENTERED ABORTING");
        }
        GridString grid = new GridString(lines);
        solve(grid);
    }

    public static void solve(GridString grid) {
        Iterator<String> iter = grid.get_adjacent_iterable(0, 0);
        String item = null;
        while (iter.hasNext()) {
            item = iter.next();
            System.out.println(item);
        }
    }
}
