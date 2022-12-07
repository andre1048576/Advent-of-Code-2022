package day7;

import java.util.ArrayList;

public class Directory {
    ArrayList<Directory> children = new ArrayList<>();
    Directory parent = null;
    String name = null;
    Integer size = 0;
    
    Directory(String name) {
        this.name = name;
    }

    Directory(String name,Directory parent) {
        this(name);
        this.parent =  parent;
    }

    public Directory add_child(String child_name) {
        Directory child = new Directory(child_name,this);
        this.children.add(child);
        return child;
    }
    public void add_size(int extra_size) {
        this.size+=extra_size;
    }

    public int get_size() {
        int total_sum = this.size;
        for (Directory d : children) {
            total_sum+=d.get_size();
        }
        return total_sum;
    }

    public Directory find_child(String param) {
        for (Directory d : children) {
            if (d.name.equals(param))
                return d;
        }
        System.out.println("COULDN'T FIND CHILD " + param + " WITHIN " + this.name);
        return null;
    }

    public String toString() {
        return this.name;
    }
}
