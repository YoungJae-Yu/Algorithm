class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double lo = 0, hi = 1;

        while (lo < hi) {
            double mid = (lo + hi) / 2;
            int count = 0;
            int p = 0, q = 1;

            for (int i = 0, j = 1; i < n - 1; i++) {
                while (j < n && arr[i] > mid * arr[j]) {
                    j++;
                }
                count += n - j;
                if (j < n && p * arr[j] < q * arr[i]) {
                    p = arr[i];
                    q = arr[j];
                }
            }

            if (count == k) {
                return new int[]{p, q};
            } else if (count < k) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        return new int[]{};
    }
}