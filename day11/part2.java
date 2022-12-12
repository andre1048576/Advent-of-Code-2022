package day11;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;

import common.InputReader;
public class part2 {
    static int day_number = 11;
    static BigInteger mult_validation = new BigInteger("1");
    public static void main(String[] args) throws Exception  {
        ArrayList<String> lines = InputReader.get_input(day_number);
        if (!part2.class.getPackage().getName().equals("day"+Integer.toString(day_number))) {
            throw new Exception("WRONG DAY_NUMBER ENTERED ABORTING");
        }
        solve(lines);
    }

    public static void simulate_round(ArrayList<Monkey> monkeys) {
        for (Monkey m : monkeys) {
            ArrayList<Pair<Integer,BigInteger>> throwing = m.inspect_all();
            for (Pair<Integer,BigInteger> item : throwing) {
                monkeys.get(item.val1).add(item.val2);
            }
        }
    }

    public static void solve(ArrayList<String> lines) {
        Iterator<String> iter = lines.iterator();
        ArrayList<Monkey> monkeys = new ArrayList<>();
        String line;
        do {
            iter.next();
            line = iter.next();
            String[] items = line.substring(18).split(",");
            line = iter.next().substring(23);
            String worry_function = line.substring(0, 1);
            String worry_amount = line.substring(2);
            line = iter.next();
            Integer validation = Integer.parseInt(line.substring(21));
            mult_validation = mult_validation.multiply(new BigInteger(validation+""));
            line = iter.next();
            Integer monkey_if_true = Integer.parseInt(line.substring(29));
            line = iter.next();
            Integer monkey_if_false = Integer.parseInt(line.substring(30));
            Monkey monkey = new Monkey(worry_function, worry_amount, validation, 
            monkey_if_true, monkey_if_false,false);
            for (String item_name : items) {
                Integer item = Integer.parseInt(item_name.trim());
                monkey.add(item);
            }
            monkeys.add(monkey);
            iter.next();
        } while (iter.hasNext());
        System.out.println(mult_validation);
        for (int i = 0; i < 10000;i++) {
            simulate_round(monkeys);
        }
        monkeys.sort(null);
        System.out.println(new BigInteger(monkeys.get(0).inspected+"").multiply(new BigInteger(monkeys.get(1).inspected+"")));
    }
}