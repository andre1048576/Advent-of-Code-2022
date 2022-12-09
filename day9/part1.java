package day9;
import java.util.ArrayList;

import common.InputReader;

public class part1 {
    static int day_number = 9;
    static ArrayList<Position> visited = new ArrayList<>();
    public static void main(String[] args) throws Exception  {
        ArrayList<String> lines = InputReader.get_input(day_number);
        if (!part1.class.getPackage().getName().equals("day"+Integer.toString(day_number))) {
            throw new Exception("WRONG DAY_NUMBER ENTERED ABORTING");
        }
        solve(lines);
    }


    public static void moveStep(Position head,Position tail,Position movement) {
        head.add(movement);
        tail.moveTowards(head);
        if (!visited.contains(tail)) {
            visited.add(new Position(tail.x,tail.y));
        }
    }


    public static void solve(ArrayList<String> lines) {
        Position head = new Position(0,0);
        Position tail = new Position(0,0);
        System.out.println(head + " " + tail);
        for (String line : lines) {
            String[] args = line.split(" ");
            Position movement = new Position(0, 0);
            switch (args[0]) {
                case "U":
                    movement.add(0,1);
                    break;
                case "D":
                    movement.add(0,-1);
                    break;
                case "R":
                    movement.add(1,0);
                    break;
                case "L":
                    movement.add(-1,0);
                    break;
            }
            for (int i = 0; i < Integer.parseInt(args[1]);i++) {
                moveStep(head, tail, movement);
            }
        }
        System.out.println(visited.size());
    }
}

