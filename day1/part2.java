package day1;
import java.util.ArrayList;
import java.util.Iterator;

import common.InputReader;
public class part2 {
    static int day_number = 1;
    public static void main(String[] args) throws Exception  {
        ArrayList<String> lines = InputReader.get_input(day_number);
        if (!part2.class.getPackage().getName().equals("day"+Integer.toString(day_number))) {
            throw new Exception("WRONG DAY_NUMBER ENTERED ABORTING");
        }
        solve(lines);
    }

    public static void solve(ArrayList<String> lines) {
        ArrayList<Integer> highest = new ArrayList<>(3);
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
                System.out.println(current_highest);
                for (int i = 0; i < 3; i++) {
                    if (highest.size() == i || current_highest > highest.get(i)) {
                        
                        highest.add(i,current_highest);
                        break;
                    }
                }
                if (highest.size() > 3) {
                    highest.remove(highest.size()-1);
                }
                System.out.println(highest);
                current_highest = 0;
            }
        }
        current_highest = 0;
        System.out.println(highest.get(0)+highest.get(1)+highest.get(2));
    }
}
