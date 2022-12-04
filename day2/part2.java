package day2;
import java.util.ArrayList;
import common.InputReader;
public class part2 {
    static int day_number = 2;
    public static void main(String[] args) throws Exception {
        ArrayList<String> lines = InputReader.get_input(day_number);
        if (!part2.class.getPackage().getName().equals("day"+Integer.toString(day_number))) {
            throw new Exception("WRONG DAY_NUMBER ENTERED ABORTING");
        }
        solve(lines);
    }

    public static void solve(ArrayList<String> lines) {
        int sum = 0;
        String[] chars;
        Hand yourHand;
        Hand elfHand;
        
        for (String line : lines) {
            chars = line.split(" ");
            elfHand = new Hand(chars[0]);
            switch(chars[1]) {
                case "X":
                    switch(chars[0]) {
                        case "A":
                            yourHand = new Hand("C");
                            break;
                        case "B":
                            yourHand = new Hand("A");
                            break;
                        case "C":
                            yourHand = new Hand("B");
                            break;
                        default:
                            yourHand = new Hand("INVALID");
                            break;
                    }
                    break;
                case "Y":
                    yourHand = new Hand(chars[0]);
                    break;
                case "Z":
                    switch(chars[0]) {
                        case "A":
                            yourHand = new Hand("B");
                            break;
                        case "B":
                            yourHand = new Hand("C");
                            break;
                        case "C":
                            yourHand = new Hand("A");
                            break;
                        default:
                            yourHand = new Hand("INVALID");
                            break;
                    }
                    break;
                default:
                    yourHand = new Hand("NO 2ND");
            }

            switch(yourHand.get_hand_type()) {
                case Paper:
                    sum+=2;
                    break;
                case Rock:
                    sum+=1;
                    break;
                case Scissors:
                    sum+=3;
                    break;
            }
            sum+=(yourHand.against(elfHand)+1)*3;
        }
        System.out.println(sum);
    }
}
