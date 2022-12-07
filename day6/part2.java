package day6;
import java.util.ArrayList;

import common.InputReader;
public class part2 {
    static int day_number = 6;
    public static void main(String[] args) throws Exception  {
        ArrayList<String> lines = InputReader.get_input(day_number);
        if (!part2.class.getPackage().getName().equals("day"+Integer.toString(day_number))) {
            throw new Exception("WRONG DAY_NUMBER ENTERED ABORTING");
        }
        solve(lines);
    }

    private static boolean is_unique(ArrayList<Character> c) {
        for (int i = 0; i < c.size()-1;i++) {
            for (int j = i+1;j<c.size();j++) {
                if (c.get(i) == c.get(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void solve(ArrayList<String> lines) {
        char[] line = lines.get(0).toCharArray();
        ArrayList<Character> character_seq = new ArrayList<>();
        int i = 0;
        for (char c : line) {
            i+=1;
            character_seq.add(c);
            if (character_seq.size() > 14) {
                character_seq.remove(0);
                if (is_unique(character_seq)) {
                    System.out.println(i);
                    System.out.println(character_seq);
                    return;
                }
                

            //first four characters
            } else if (character_seq.size() == 14) {
                if (is_unique(character_seq)) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}
