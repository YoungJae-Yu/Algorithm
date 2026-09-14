import java.util.*;

class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        String[] names = new String[n];
        int[] times = new int[n];
        int[] amounts = new int[n];
        String[] cities = new String[n];
        boolean[] invalid = new boolean[n];
        Map<String, List<Integer>> byName = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] parts = transactions[i].split(",");
            names[i] = parts[0];
            times[i] = Integer.parseInt(parts[1]);
            amounts[i] = Integer.parseInt(parts[2]);
            cities[i] = parts[3];
            if (amounts[i] > 1000) invalid[i] = true;
            byName.computeIfAbsent(names[i], k -> new ArrayList<>()).add(i);
        }

        for (List<Integer> idxs : byName.values()) {
            for (int a = 0; a < idxs.size(); a++) {
                int i = idxs.get(a);
                for (int b = a + 1; b < idxs.size(); b++) {
                    int j = idxs.get(b);
                    if (!cities[i].equals(cities[j]) && Math.abs(times[i] - times[j]) <= 60) {
                        invalid[i] = true;
                        invalid[j] = true;
                    }
                }
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (invalid[i]) result.add(transactions[i]);
        }
        return result;
    }
}