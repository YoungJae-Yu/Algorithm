class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> current = new ArrayList<>();
        for (int d = 1; d <= 9; d++) {
            current.add(d);
        }
        
        for (int i = 1; i < n; i++) {
            List<Integer> next = new ArrayList<>();
            for (int num : current) {
                int lastDigit = num % 10;
                if (lastDigit + k <= 9) {
                    next.add(num * 10 + lastDigit + k);
                }
                if (k != 0 && lastDigit - k >= 0) {
                    next.add(num * 10 + lastDigit - k);
                }
            }
            current = next;
        }
        
        return current.stream().mapToInt(Integer::intValue).toArray();
    }
}