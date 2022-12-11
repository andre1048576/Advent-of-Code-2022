package day10;
import java.util.ArrayList;
import java.util.Iterator;
import common.InputReader;
public class part2 {
    static int day_number = 10;
    public static void main(String[] args) throws Exception  {
        ArrayList<String> lines = InputReader.get_input(day_number);
        if (!part2.class.getPackage().getName().equals("day"+Integer.toString(day_number))) {
            throw new Exception("WRONG DAY_NUMBER ENTERED ABORTING");
        }
        solve(lines);
    }

    static class Pair<T,J> {
        T val1;
        J val2;
        Pair(T val1,J val2) {
            this.val1 = val1;
            this.val2 = val2;
        }
    }

    /**
     * 
     *
     * @return Whether the handler should skip to the next line
     */
    public static Pair<Boolean,Integer> handle_command(String line,int cycles_in_command) {
        if (line.equals("noop")) {
            return new Pair<Boolean,Integer>(true,0);
        } else if (cycles_in_command == 1) {
            return new Pair<Boolean,Integer>(true,Integer.parseInt(line.substring(5)));
        } else {
            return new Pair<Boolean,Integer>(false,0);
        }
    }


    public static void solve(ArrayList<String> lines) {
        Iterator<String> iter = lines.iterator();
        int cycle = 0;
        int local_cycle = 0;
        int register_sum = 1;
        String display = "";
        String line = iter.next();
        while (cycle < 240) {
            Pair<Boolean,Integer> output = handle_command(line, local_cycle);
            if (cycle < 40)
                System.out.println(cycle + " " + register_sum);
            if (Math.abs(register_sum-cycle%40) <= 1) {
                display+="#";
            } else {
                display+=".";
            }
            if (cycle%40==39) {
                display+="\n";
            }
            cycle+=1;
            register_sum += output.val2;
            if (output.val1) {
                local_cycle=0;
                if (iter.hasNext())
                    line = iter.next();
                else
                    break;
            } else {
                local_cycle+=1;
            }
        }
        System.out.println(display);
    }
}

