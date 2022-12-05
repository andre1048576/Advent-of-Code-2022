package day1;
import java.util.ArrayList;
import java.util.Iterator;

import common.InputReader;
public class part1 {
    static int day_number = 1;
    public static void main(String[] args) throws Exception  {
        ArrayList<String> lines = InputReader.get_input(day_number);
        if (!part1.class.getPackage().getName().equals("day"+Integer.toString(day_number))) {
            throw new Exception("WRONG DAY_NUMBER ENTERED ABORTING");
        }
        solve(lines);
    }

    public static void solve(ArrayList<String> lines) {
        int highest = 0;
        int current_highest = 0;
        Iterator<String> iter = lines.iterator();
        String curr_line = "";
        while (iter.hasNext()) {
            curr_line = iter.next();
            //we have found a number
            if (curr_line.length() > 0) {
                current_highest+= Integer.parseInt(curr_line);
            //we have finished counting for the current elf
            } else {
                if (current_highest > highest) {
                    highest = current_highest;
                }
                current_highest = 0;
            }
        }
        System.out.println(highest);
    }
}

