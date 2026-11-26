class Solution {
    public int findMinFibonacciNumbers(int k) {
        long a = 1, b = 1;
        while (b <= k) {
            long c = a + b;
            a = b;
            b = c;
        }
        int count = 0;
        while (k > 0) {
            while (a > k) {
                long p = b - a;
                b = a;
                a = p;
            }
            k -= (int) a;
            count++;
        }
        return count;
    }
}