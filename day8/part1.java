package day8;
import java.util.ArrayList;
import common.GridInteger;
import common.InputReader;

public class part1 {
    static int day_number = 8;
    public static void main(String[] args) throws Exception  {
        ArrayList<String> lines = InputReader.get_input(day_number);
        if (!part1.class.getPackage().getName().equals("day"+Integer.toString(day_number))) {
            throw new Exception("WRONG DAY_NUMBER ENTERED ABORTING");
        }
        GridInteger grid = new GridInteger(lines);
        solve(grid);
    }


    public static boolean viewable_up(GridInteger grid, int row,int column) {
        int self_value = grid.get_index(row, column);
        for (int i = column-1;i >= 0;i--) {
            if (grid.get_index(row, i) >= self_value)
                return false;
        }
        return true;
    }
    
    public static boolean viewable_down(GridInteger grid, int row,int column) {
        int self_value = grid.get_index(row, column);
        for (int i = column+1;i < grid.get_height();i++) {
            if (grid.get_index(row, i) >= self_value)
                return false;
        }
        return true;
    }
    
    public static boolean viewable_left(GridInteger grid, int row,int column) {
        int self_value = grid.get_index(row, column);
        for (int i = row-1;i >= 0;i--) {
            if (grid.get_index(i, column) >= self_value)
                return false;
        }
        return true;
    }

    public static boolean viewable_right(GridInteger grid, int row,int column) {
        int self_value = grid.get_index(row, column);
        for (int i = row+1;i < grid.get_width();i++) {
            if (grid.get_index(i, column) >= self_value)
                return false;
        }
        return true;
    }
    
    /**
    *
    * @return This function returns 1 if the cell can be viewed from any side
    */
    public static int index_viewable(GridInteger grid, int row,int column) {
        if (
            viewable_up(grid, row, column) ||
            viewable_down(grid, row, column) ||
            viewable_left(grid, row, column) ||
            viewable_right(grid, row, column) 
           )
            return 1;
        return 0;
    }

    public static void solve(GridInteger grid) {
        Integer viewable = 0;
        for (int row = 0;row < grid.get_width();row++) {
            for (int column = 0;column < grid.get_height();column++) {
                viewable+=index_viewable(grid,row,column);
            }
        }
        System.out.println(viewable);
    }
}

