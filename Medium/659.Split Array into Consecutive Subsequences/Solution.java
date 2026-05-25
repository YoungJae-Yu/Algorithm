class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> tail = new HashMap<>();
        
        for (int n : nums) {
            freq.merge(n, 1, Integer::sum);
        }
        
        for (int n : nums) {
            if (freq.getOrDefault(n, 0) == 0) continue;
            
            if (tail.getOrDefault(n, 0) > 0) {
                tail.merge(n, -1, Integer::sum);
                tail.merge(n + 1, 1, Integer::sum);
                freq.merge(n, -1, Integer::sum);
            } else if (freq.getOrDefault(n + 1, 0) > 0 && freq.getOrDefault(n + 2, 0) > 0) {
                freq.merge(n, -1, Integer::sum);
                freq.merge(n + 1, -1, Integer::sum);
                freq.merge(n + 2, -1, Integer::sum);
                tail.merge(n + 3, 1, Integer::sum);
            } else {
                return false;
            }
        }
        
        return true;
    }
}