package day3;
import java.util.ArrayList;

import common.InputReader;
public class part1 {
    static int day_number = 3;
    public static void main(String[] args) throws Exception {
        ArrayList<String> lines = InputReader.get_input(day_number);
        if (!part1.class.getPackage().getName().equals("day"+Integer.toString(day_number))) {
            throw new Exception("WRONG DAY_NUMBER ENTERED ABORTING");
        }
        solve(lines);
    }

    public static void solve(ArrayList<String> lines) {
        int sum = 0;
        for (String line : lines) {
            int mid = line.length() / 2; //get the middle of the String
            char[] first_half = line.substring(0,mid).toCharArray();
            char[] second_half = line.substring(mid).toCharArray();
            ArrayList<Character> common_items = new ArrayList<>();
            for (char c : first_half) {
                for (int i = 0;i < second_half.length;i++) {
                    if (second_half[i] == c) {
                        if (common_items.contains(c))
                            break;
                        common_items.add(c);
                        break;
                    }
                }
            }

            for (char i : common_items) {
                //some arbitrary value between the ascii value of Z (90) and the ascii value of a (97)
                //A is (65)
                if (i < 92) {
                    sum+=(i-38);
                } else {
                    sum+=(i-96);
                }
            }
        }
        System.out.println(sum);
    }
}

