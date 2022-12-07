package day7;
import java.util.ArrayList;
import java.util.Iterator;
import common.InputReader;
public class part1 {
    static int day_number = 7;
    static ArrayList<Directory> directories = new ArrayList<>();
    static Directory current_directory;
    public static void main(String[] args) throws Exception  {
        ArrayList<String> lines = InputReader.get_input(day_number);
        if (!part1.class.getPackage().getName().equals("day"+Integer.toString(day_number))) {
            throw new Exception("WRONG DAY_NUMBER ENTERED ABORTING");
        }
        solve(lines);
    }

    static String line;

    public static void generate_directory(String name) {
        Directory d;
        d = current_directory.add_child(name);
        directories.add(d);
    }

    public static void handle_list(Iterator<String> iter) {
        line = iter.next();
        while (!line.startsWith("$")) {
            if (!line.startsWith("dir"))
                current_directory.add_size(Integer.parseInt(line.split(" ")[0]));
            else {
                generate_directory(line.substring(4));
            }
            if (iter.hasNext())
                line = iter.next();
            else
                break;
        }   
        System.out.println("finishing line: " + line);
    }
    
    public static void go_to(String param) {
        //generating the root of the directory
        if (current_directory == null) {
            Directory d;
            d = new Directory(param);
            current_directory = d;
            directories.add(d);
            return;
        }
        if (param.equals("..")) {
            current_directory = current_directory.parent;
            return; 
        } else {
            current_directory = current_directory.find_child(param);
        }
    }

    /**
     * 
     * @return  whether the iterator should iter.next() to reach an unexplored line
     */
    public static boolean handle_command(String cmd,Iterator<String> iter) {
        if (cmd.startsWith("cd")) {
            String param = cmd.substring(3);
            go_to(param);
            return true;
        } else {
            handle_list(iter);
            return false;
        }
    }


    public static void solve(ArrayList<String> lines) {
        Iterator<String> iter = lines.iterator();
        line = iter.next();
        while (iter.hasNext()) {
            if (handle_command(line.substring(2), iter))
                line = iter.next();
        }
        int sum = 0;
        for (Directory d : directories) {
            if (d.get_size()<100000)
                sum+=d.get_size();
        }
        System.out.println(sum);
    }
}

