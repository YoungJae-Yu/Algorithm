class Solution {
    public int[] singleNumber(int[] nums) {
        int xorAll = 0;
        for (int n : nums) xorAll ^= n;
        int diff = xorAll & (-xorAll);
        int[] result = new int[2];
        for (int n : nums) {
            if ((n & diff) == 0) {
                result[0] ^= n;
            } else {
                result[1] ^= n;
            }
        }
        return result;
    }
}