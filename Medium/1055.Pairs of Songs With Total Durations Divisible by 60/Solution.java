class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        int result = 0;
        for (int t : time) {
            int r = t % 60;
            int complement = (60 - r) % 60;
            result += count[complement];
            count[r]++;
        }
        return result;
    }
}