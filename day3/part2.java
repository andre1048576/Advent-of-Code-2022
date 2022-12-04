package day3;
import java.util.ArrayList;
import java.util.Iterator;

import common.InputReader;
public class part2 {
    static int day_number = 3;
    public static void main(String[] args) throws Exception {
        ArrayList<String> lines = InputReader.get_input(day_number);
        if (!part2.class.getPackage().getName().equals("day"+Integer.toString(day_number))) {
            throw new Exception("WRONG DAY_NUMBER ENTERED ABORTING");
        }
        solve(lines);
    }

    public static void solve(ArrayList<String> lines) {
        int sum = 0;
        Iterator<String> line_iter = lines.iterator();
        while (line_iter.hasNext()) {
            char[] line1 = line_iter.next().toCharArray();
            char[] line2 = line_iter.next().toCharArray();
            char[] line3 = line_iter.next().toCharArray();
            ArrayList<Character> common_items_12 = new ArrayList<>();
            for (char c : line1) {
                for (int i = 0;i < line2.length;i++) {
                    if (line2[i] == c) {
                        if (common_items_12.contains(c))
                            break;
                        common_items_12.add(c);
                        break;
                    }
                }
            }
            int i = 0;
            for (char c : line3) {
                if (common_items_12.contains(c)) {
                    i = c;
                    break;
                }
            }
            if (i < 92) {
                sum+=(i-38);
            } else {
                sum+=(i-96);
            }
        }
        System.out.println(sum);
    }
}
