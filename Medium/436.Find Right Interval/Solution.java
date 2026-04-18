import java.util.TreeMap;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];
        
        TreeMap<Integer, Integer> startToIndex = new TreeMap<>();
        
        for (int i = 0; i < n; i++) {
            startToIndex.put(intervals[i][0], i);
        }
        
        for (int i = 0; i < n; i++) {
            Integer key = startToIndex.ceilingKey(intervals[i][1]);
            result[i] = (key == null) ? -1 : startToIndex.get(key);
        }
        
        return result;
    }
}