class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] minutes = new boolean[1440];
        
        for (String time : timePoints) {
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3, 5));
            int total = h * 60 + m;
            if (minutes[total]) return 0;
            minutes[total] = true;
        }
        
        int minDiff = Integer.MAX_VALUE;
        int first = -1;
        int prev = -1;
        
        for (int i = 0; i < 1440; i++) {
            if (minutes[i]) {
                if (first == -1) {
                    first = i;
                } else {
                    minDiff = Math.min(minDiff, i - prev);
                }
                prev = i;
            }
        }
        
        minDiff = Math.min(minDiff, 1440 - prev + first);
        
        return minDiff;
    }
}