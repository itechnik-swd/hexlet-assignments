package exercise;

import java.util.Arrays;

class SafetyList {
    // BEGIN
    private int[] list;

    SafetyList() {
        list = new int[0];
    }

    public synchronized void add(int value) {
        list = Arrays.copyOf(list, list.length + 1);
        list[list.length - 1] = value;
    }

    public int get(int index) {
        return list[index];
    }

    public int getSize() {
        return list.length;
    }
    // END
}
