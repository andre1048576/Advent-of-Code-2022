package day1;
import java.util.ArrayList;
import common.InputReader;
public class part1 {
    static int day_number = 1;
    public static void main(String[] args)  {
        ArrayList<String> lines = InputReader.get_from_url(day_number);
        if (!part1.class.getPackage().getName().equals("day"+Integer.toString(day_number))) {
            System.out.println("WRONG");
        }
        for (String l : lines) {
            System.out.println(l);
        }

        solve(lines);
    }

    public static void solve(ArrayList<String> lines) {

    }
}

