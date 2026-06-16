class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> count = new TreeMap<>();
        for (int x : arr) {
            count.merge(x, 1, Integer::sum);
        }
        
        for (int x : count.keySet()) {
            if (count.get(x) == 0) continue;
            
            int target = x < 0 ? x / 2 : x * 2;
            
            if (x < 0 && x % 2 != 0) return false;
            
            int need = count.get(x);
            int available = count.getOrDefault(target, 0);
            
            if (available < need) return false;
            
            count.put(target, available - need);
        }
        
        return true;
    }
}