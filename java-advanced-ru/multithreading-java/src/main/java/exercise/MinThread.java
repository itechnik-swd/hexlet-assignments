package exercise;

// BEGIN
class MinThread extends Thread {
    private final int[] array;
    private int min;

    public MinThread(int[] array) {
        this.array = array;
        this.min = array[0];
    }

    @Override
    public void run() {
        for (int j : array) {
            if (j < min) {
                min = j;
            }
        }
    }

    public int getMin() {
        return min;
    }
}
// END
