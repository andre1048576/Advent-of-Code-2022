package common;

import java.util.ArrayList;

public class GridString extends Grid<String> {
    
    public GridString(ArrayList<String> lines) {
        super(lines);
    }

    public String[] format(String line) {
        return line.split("(?!^)");
    }
}
