class Solution {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> fibs = new ArrayList<>();
        int a = 1, b = 1;
        while (a <= k) {
            fibs.add(a);
            int next = a + b;
            a = b;
            b = next;
        }
        
        int count = 0;
        int remaining = k;
        
        for (int i = fibs.size() - 1; i >= 0 && remaining > 0; i--) {
            if (fibs.get(i) <= remaining) {
                remaining -= fibs.get(i);
                count++;
            }
        }
        
        return count;
    }
}