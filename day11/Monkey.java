package day11;

import java.math.BigInteger;
import java.util.ArrayList;

public class Monkey implements Comparable<Monkey> {
    Integer inspected = 0;
    String worry_function;
    String worry_amount;
    Integer validation;
    Integer monkey_if_true;
    Integer monkey_if_false;
    ArrayList<BigInteger> items = new ArrayList<>();
    Boolean bored = true;
    //static BigInteger max_validation = new BigInteger("96577");
    static BigInteger max_validation = new BigInteger("9699690");

    public ArrayList<Pair<Integer,BigInteger>> inspect_all() {
        ArrayList<Pair<Integer,BigInteger>> output = new ArrayList<>();
        for (int i = 0;i < items.size();i+=1) {
            if (inspect(i)) {  
                output.add(new Pair<Integer,BigInteger>(monkey_if_true,items.get(i)));
            } else {
                output.add(new Pair<Integer,BigInteger>(monkey_if_false,items.get(i)));
            }
        }
        reset();
        return output;
    }

    Monkey(String worry_function,String worry_amount,Integer validation,
        Integer monkey_if_true,Integer monkey_if_false) {

        this.worry_function = worry_function;
        this.worry_amount = worry_amount;
        this.validation = validation;
        this.monkey_if_true = monkey_if_true;
        this.monkey_if_false = monkey_if_false;
    }

    Monkey(String worry_function,String worry_amount,Integer validation,
        Integer monkey_if_true,Integer monkey_if_false,Boolean bored) {
        this(worry_function, worry_amount, validation, monkey_if_true, monkey_if_false);
        this.bored = bored;
    }

    public void reset() {
        items = new ArrayList<>();
    }

    public void add(BigInteger value) {
        items.add(value);
    }

    public void add(Integer value) {
        items.add(new BigInteger(value+""));
    }

    private BigInteger get_worry_amount(int index) {
        if (worry_amount.equals("old")) {
            return items.get(index);
        }
        return new BigInteger(worry_amount);
    }

    private boolean inspect(int index) {
        this.inspected+=1;
        switch (worry_function) {
            case "+":
                items.set(index,(items.get(index).add(get_worry_amount(index))));
                break;
            case "*":
                items.set(index,items.get(index).multiply(get_worry_amount(index)));
                break;
            default:
                break;
        }
        if (bored)
            bored(index);
        else
            reduce(index);
        return test_passes(index);
    }

    private boolean test_passes(int index) {
        return items.get(index).mod( new BigInteger(validation.toString()) ).equals(new BigInteger("0"));
    }

    private void bored(int index) {
    //    items.set(index, items.get(index)/3);
    }

    private void reduce(int index) {
        items.set(index,items.get(index).mod(max_validation));
    }

    public String toString() {
        return this.items.toString() + " " + inspected;
    }

    @Override
    public int compareTo(Monkey o) {
        return o.inspected.compareTo(this.inspected);
    }
}
