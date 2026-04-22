class Solution {
    public double[] sampleStats(int[] count) {
        int minimum = -1;
        int maximum = -1;
        long totalSum = 0;
        long totalCount = 0;
        int mode = 0;
        int maxFrequency = 0;
        
        for (int i = 0; i < 256; i++) {
            if (count[i] > 0) {
                if (minimum == -1) {
                    minimum = i;
                }
                maximum = i;
                totalSum += (long) i * count[i];
                totalCount += count[i];
                if (count[i] > maxFrequency) {
                    maxFrequency = count[i];
                    mode = i;
                }
            }
        }
        
        double mean = (double) totalSum / totalCount;
        
        double median;
        if (totalCount % 2 == 1) {
            long target = (totalCount + 1) / 2;
            median = findKth(count, target);
        } else {
            long target1 = totalCount / 2;
            long target2 = totalCount / 2 + 1;
            median = (findKth(count, target1) + findKth(count, target2)) / 2.0;
        }
        
        return new double[] {minimum, maximum, mean, median, mode};
    }
    
    private double findKth(int[] count, long k) {
        long cumulative = 0;
        for (int i = 0; i < 256; i++) {
            cumulative += count[i];
            if (cumulative >= k) {
                return i;
            }
        }
        return -1;
    }
}