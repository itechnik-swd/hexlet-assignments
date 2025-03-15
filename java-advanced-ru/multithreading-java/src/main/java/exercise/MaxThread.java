package exercise;

// BEGIN
class MaxThread extends Thread {
    private final int[] array;
    private int max;

    public MaxThread(int[] array) {
        this.array = array;
        this.max = array[0];
    }

    @Override
    public void run() {
        for (int j : array) {
            if (j > max) {
                max = j;
            }
        }
    }

    public int getMax() {
        return max;
    }
}
// END
