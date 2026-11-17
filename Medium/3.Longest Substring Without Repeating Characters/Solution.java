class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];
        int best = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) & 127;
            if (last[c] > start) start = last[c];
            last[c] = i + 1;
            best = Math.max(best, i + 1 - start);
        }
        return best;
    }
}