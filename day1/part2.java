package day1;
import java.util.ArrayList;
import common.InputReader;
public class part2 {
    static int day_number = 1;
    public static void main(String[] args)  {
        ArrayList<String> lines = InputReader.get_from_url(day_number);
        if (!part2.class.getPackage().getName().equals("day"+Integer.toString(day_number))) {
            System.out.println("WRONG DAY_NUMBER ENTERED");
        }
        for (String l : lines) {
            System.out.println(l);
        }
        solve(lines);
    }

    public static void solve(ArrayList<String> lines) {

    }
}
