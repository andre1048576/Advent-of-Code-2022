package common;

import java.util.ArrayList;

public class GridInteger extends Grid<Integer> {
    
    public GridInteger(ArrayList<String> lines) {
        super(lines);
    }

    public Integer[] format(String line) {
        Integer[] output_array = new Integer[line.length()];
        for (int i = 0; i < line.length();i++) {
            output_array[i] = Integer.parseInt(Character.toString(line.charAt(i)));
        }
        return output_array;
    }
}
