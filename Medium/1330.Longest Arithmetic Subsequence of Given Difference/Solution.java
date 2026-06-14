class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        var dp = new java.util.HashMap<Integer, Integer>();
        int maxLen = 1;
        
        for (int num : arr) {
            int prev = dp.getOrDefault(num - difference, 0);
            int curr = prev + 1;
            dp.put(num, curr);
            maxLen = Math.max(maxLen, curr);
        }
        
        return maxLen;
    }
}