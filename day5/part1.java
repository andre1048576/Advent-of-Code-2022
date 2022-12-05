package day5;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

import common.InputReader;
public class part1 {
    static int day_number = 5;
    public static void main(String[] args) throws Exception  {
        ArrayList<String> lines = InputReader.get_input(day_number);
        if (!part1.class.getPackage().getName().equals("day"+Integer.toString(day_number))) {
            throw new Exception("WRONG DAY_NUMBER ENTERED ABORTING");
        }
        solve(lines);
    }

    public static void solve(ArrayList<String> lines) {
        Iterator<String> iter = lines.iterator();
        boolean counting_stack = false;
        String curr_line = "";
        ArrayList<ArrayDeque<String>> Stacks = new ArrayList<>();
        do {
            curr_line = iter.next();
            //initialize the stacks
            if (!counting_stack) {
                for (int i = 0;i < curr_line.length();i+=4) {
                    Stacks.add(new ArrayDeque<String>());
                }
            }
            if (curr_line.charAt(0) != '[') {
                counting_stack = false;
            } else {
                //append any values found to the stacks
                counting_stack = true;
                for (int i = 1;i < curr_line.length();i+=4) {
                    if (Character.getNumericValue(curr_line.charAt(i)) > 0) {
                        Stacks.get(i/4).addLast(Character.toString(curr_line.charAt(i)));
                    }
                }
            }
        } while (counting_stack);
        iter.next();
        String[] mov_string = new String[3];
        Integer[] mov_int = new Integer[3];
        while (iter.hasNext()) {
            curr_line = iter.next().replaceAll("[a-zA-Z]+\s", "");
            mov_string = curr_line.split("\s");
            for (int i = 0; i < 3;i++) {
                mov_int[i] = Integer.parseInt(mov_string[i]);
            }
            for (int i = 0; i < mov_int[0];i++) {
                Stacks.get(mov_int[2]-1).addFirst(Stacks.get(mov_int[1]-1).removeFirst());
            }
        }
        for (int i = 0; i < Stacks.size();i++) {
            System.out.print(Stacks.get(i).getFirst());
        }
    }
}

