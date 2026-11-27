import java.util.Random;

class Solution {
    private final int[] original;
    private int[] current;
    private final Random rnd = new Random();

    public Solution(int[] nums) {
        original = nums.clone();
        current = nums.clone();
    }

    public int[] reset() {
        current = original.clone();
        return current.clone();
    }

    public int[] shuffle() {
        for (int i = current.length - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            int t = current[i];
            current[i] = current[j];
            current[j] = t;
        }
        return current.clone();
    }
}