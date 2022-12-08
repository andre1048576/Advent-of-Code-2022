package day8;
import java.util.ArrayList;
import common.GridInteger;
import common.InputReader;

public class part2 {
    static int day_number = 8;
    public static void main(String[] args) throws Exception  {
        ArrayList<String> lines = InputReader.get_input(day_number);
        if (!part2.class.getPackage().getName().equals("day"+Integer.toString(day_number))) {
            throw new Exception("WRONG DAY_NUMBER ENTERED ABORTING");
        }
        GridInteger grid = new GridInteger(lines);
        solve(grid);
    }


    public static int viewable_up(GridInteger grid, int row,int column) {
        int viewable = 0;
        int self_value = grid.get_index(row, column);
        for (int i = column-1;i >= 0;i--) {
            viewable+=1;
            if (grid.get_index(row, i) >= self_value)
                break;
        }
        return viewable;
    }
    
    public static int viewable_down(GridInteger grid, int row,int column) {
        int viewable = 0;
        int self_value = grid.get_index(row, column);
        for (int i = column+1;i < grid.get_height();i++) {
            viewable+=1;
            if (grid.get_index(row, i) >= self_value)
                break;
        }
        return viewable;
    }
    
    public static int viewable_left(GridInteger grid, int row,int column) {
        int viewable = 0;
        int self_value = grid.get_index(row, column);
        for (int i = row-1;i >= 0;i--) {
            viewable+=1;
            if (grid.get_index(i, column) >= self_value)
                break;
            }
        return viewable;
        }

    public static int viewable_right(GridInteger grid, int row,int column) {
        int viewable = 0;
        int self_value = grid.get_index(row, column);
        for (int i = row+1;i < grid.get_width();i++) {
            viewable+=1;
            if (grid.get_index(i, column) >= self_value)
                break;
            }
        return viewable;
    }
    
    /**
    *
    * @return This function returns 1 if the cell can be viewed from any side
    */
    public static int index_viewable(GridInteger grid, int row,int column) {
        return viewable_up(grid, row, column) *
            viewable_down(grid, row, column) *
            viewable_left(grid, row, column) *
            viewable_right(grid, row, column);
    }

    public static void solve(GridInteger grid) {
        Integer viewable = 0;
        for (int row = 0;row < grid.get_width();row++) {
            for (int column = 0;column < grid.get_height();column++) {
                viewable=Math.max(viewable,index_viewable(grid,row,column));
            }
        }
        System.out.println(viewable);
    }
}

