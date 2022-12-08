package common;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Grid<T> {

    class GridIterator<G> implements Iterator<G> {

        private ArrayList<G> values;
        private int i;
        GridIterator() {
            i = 0;
            values = new ArrayList<>();
        }

        public void add(G new_value) {
            values.add(new_value);
        }

        @Override
        public boolean hasNext() {
            return i < values.size();
        }

        @Override
        public G next() {
            return values.get(i++);
        }

    }


    ArrayList<ArrayList<T>> internal_grid;
    private int size_x;
    private int size_y;

    Grid(ArrayList<String> lines) {
        size_y = 0;
        internal_grid = new ArrayList<>();
        for (String line : lines) {
            if (size_y++ == 0)
                size_x = line.length();
            ArrayList<T> new_array_list = new ArrayList<>();
            for (T item : format(line))
                new_array_list.add(item);
            internal_grid.add(new_array_list);
        }
        size_y = internal_grid.size();
    }

    public abstract T[] format(String line);

    public T get_index(int x,int y) {
        
        if (index_exists(x, y)) {
            return internal_grid.get(y).get(x);
        }
        return null;
    }

    public int get_width() {
        return size_x;
    }

    public int get_height() {
        return size_y;
    }

    /*
     * Returns all adjacent squares from a specified index like how we read books
     */
    public Iterator<T> get_adjacent_iterable(int x,int y) {
        GridIterator<T> iterator = new GridIterator<T>();
        int[][] arr = {{-1,-1},{0,-1},{1,-1},{-1,0},{1,0},{-1,1},{0,1},{1,1}};
        for (int[] i : arr) {
            T value_at_index = get_index(x + i[0], y + i[1]);
            if (value_at_index != null) 
                iterator.add(value_at_index);
        }
        return iterator;
    }
    
    public boolean index_exists(int x, int y) {
        if (x < 0 || y < 0) 
            return false;
        return x < size_x && y < size_y;
    }
}
