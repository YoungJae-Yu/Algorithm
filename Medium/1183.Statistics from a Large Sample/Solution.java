class Solution {
    public double[] sampleStats(int[] count) {
        int min = -1, max = -1;
        long total = 0, sum = 0;
        long maxFreq = -1;
        double mode = 0;
        for (int i = 0; i < 256; i++) {
            if (count[i] > 0) {
                if (min == -1) min = i;
                max = i;
                total += count[i];
                sum += (long) count[i] * i;
                if (count[i] > maxFreq) {
                    maxFreq = count[i];
                    mode = i;
                }
            }
        }
        double mean = (double) sum / total;
        long mid1 = (total + 1) / 2;
        long mid2 = (total + 2) / 2;
        long cum = 0;
        double m1 = -1, m2 = -1;
        for (int i = 0; i < 256; i++) {
            cum += count[i];
            if (m1 == -1 && cum >= mid1) m1 = i;
            if (m2 == -1 && cum >= mid2) m2 = i;
            if (m1 != -1 && m2 != -1) break;
        }
        double median = (m1 + m2) / 2.0;
        return new double[]{min, max, mean, median, mode};
    }
}