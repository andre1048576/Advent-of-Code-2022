package day4;
import java.util.ArrayList;
import java.util.Iterator;

import common.InputReader;
public class part2 {
    static int day_number = 4;
    public static void main(String[] args) throws Exception  {
        ArrayList<String> lines = InputReader.get_input(day_number);
        if (!part2.class.getPackage().getName().equals("day"+Integer.toString(day_number))) {
            throw new Exception("WRONG DAY_NUMBER ENTERED ABORTING");
        }
        solve(lines);
    }

    public static void solve(ArrayList<String> lines) {
        int excess = 0;
        Iterator<String> iter = lines.iterator();
        String curr_line = "";
        while (iter.hasNext()) {
            curr_line = iter.next();
            String[] elfs = curr_line.split(",");
            ArrayList<Integer> borders = new ArrayList<>();
            String[] temp = elfs[0].split("-");
            borders.add(Integer.parseInt(temp[0]));
            borders.add(Integer.parseInt(temp[1]));
            temp = elfs[1].split("-");
            borders.add(Integer.parseInt(temp[0]));
            borders.add(Integer.parseInt(temp[1]));
            System.out.println(borders);
            if (((borders.get(2) >= borders.get(0) && borders.get(2) <= borders.get(1)) || (borders.get(3) >= borders.get(0) && borders.get(3) <= borders.get(1))) ||
            ((borders.get(0) >= borders.get(2) && borders.get(0) <= borders.get(3)) || (borders.get(1) >= borders.get(2) && borders.get(1) <= borders.get(3)))) {
                excess+=1;
            }
        }
        System.out.println(excess);
    }
}
