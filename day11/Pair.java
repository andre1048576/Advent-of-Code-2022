package day11;

class Pair<T,J> {
    T val1;
    J val2;
    Pair(T val1,J val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public String toString() {
        return val1.toString() + " " + val2.toString();
    }
}
