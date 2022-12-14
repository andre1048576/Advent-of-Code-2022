package common;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Grid<T> {

    class GridIterator<G> implements Iterator<G> {

        private ArrayList<G> values;
        GridIterator() {
            values = new ArrayList<>();
        }

        public void add(G new_value) {
            values.add(new_value);
        }

        @Override
        public boolean hasNext() {
            return values.size() > 0;
        }

        @Override
        public G next() {
            G val = values.get(0);
            values.remove(0);
            return val;
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

    public T get(Position p) {
        
        if (index_exists(p)) {
            return internal_grid.get(p.y).get(p.x);
        }
        return null;
    }

    public void replace(Position p,T new_value) {
        internal_grid.get(p.y).remove(p.x);
        internal_grid.get(p.y).add(p.x,new_value);
    }

    //reads like a book
    public Iterator<Position> get_all_indexes() {
        GridIterator<Position> iterator = new GridIterator<Position>();
        for (int x = 0;x < size_x;x++) {
            for (int y=0;y<size_y;y++) {
                iterator.add(new Position(x,y));
            }
        }
        return iterator;
    }

    public int get_width() {
        return size_x;
    }

    public int get_height() {
        return size_y;
    }

    /*
     * Returns all adjacent positions from a specified index in a cross pattern
     */
    public Iterator<Position> get_adjacent_cross(Position center) {
        ArrayList<Position> adjacency = new ArrayList<>();
        Position above = new Position(0,1);
        above.add(center);
        Position below = new Position(0,-1);
        below.add(center);
        Position right = new Position(1,0);
        right.add(center);
        Position left = new Position(-1,0);
        left.add(center);
        if (index_exists(above))
            adjacency.add(above);
        if (index_exists(below))
            adjacency.add(below);
        if (index_exists(right))
            adjacency.add(right);
        if (index_exists(left))
            adjacency.add(left);
        return adjacency.iterator();
    }
    
    /*
     * Returns all adjacent squares from a specified index like how we read books
     */
    public Iterator<T> get_adjacent(Position center) {
        GridIterator<T> iterator = new GridIterator<T>();
        ArrayList<Position> adjacency = new ArrayList<>();
        for (int i = -1;i<=1;i++) {
            for (int j =-1;j<=1;j++) {
                if (i == 0 && j == 0) 
                    continue;
                Position temp = new Position(i, j);
                temp.add(center);
                adjacency.add(temp);
            }
        }
        for (Position p : adjacency) {
            T value_at_index = get(p);
            if (value_at_index != null) 
                iterator.add(value_at_index);
        }
        return iterator;
    }
    
    public boolean index_exists(Position p) {
        if (p.x < 0 || p.y < 0) 
            return false;
        return p.x < size_x && p.y < size_y;
    }
}
