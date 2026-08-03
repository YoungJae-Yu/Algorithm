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
                Set<Integer> candidates = new LinkedHashSet<>();
                if (lastDigit + k <= 9) candidates.add(lastDigit + k);
                if (lastDigit - k >= 0) candidates.add(lastDigit - k);
                for (int c : candidates) {
                    next.add(num * 10 + c);
                }
            }
            current = next;
        }

        return current.stream().mapToInt(Integer::intValue).toArray();
    }
}