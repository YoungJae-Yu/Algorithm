# 1272. Invalid Transactions

https://leetcode.com/problems/invalid-transactions/

A transaction is possibly invalid if:

	the amount exceeds $1000, or;
	if it occurs within (and including) 60 minutes of another transaction with the same name in a different city.

You are given an array of strings transaction where transactions[i] consists of comma-separated values representing the name, time (in minutes), amount, and city of the transaction.

Return a list of transactions that are possibly invalid. You may return the answer in any order.

 
Example 1:

Input: transactions = [&quot;alice,20,800,mtv&quot;,&quot;alice,50,100,beijing&quot;]
Output: [&quot;alice,20,800,mtv&quot;,&quot;alice,50,100,beijing&quot;]
Explanation: The first transaction is invalid because the second transaction occurs within a difference of 60 minutes, have the same name and is in a different city. Similarly the second one is invalid too.

Example 2:

Input: transactions = [&quot;alice,20,800,mtv&quot;,&quot;alice,50,1200,mtv&quot;]
Output: [&quot;alice,50,1200,mtv&quot;]

Example 3:

Input: transactions = [&quot;alice,20,800,mtv&quot;,&quot;bob,50,1200,mtv&quot;]
Output: [&quot;bob,50,1200,mtv&quot;]

 
Constraints:

	transactions.length <= 1000
	Each transactions[i] takes the form &quot;{name},{time},{amount},{city}&quot;
	Each {name} and {city} consist of lowercase English letters, and have lengths between 1 and 10.
	Each {time} consist of digits, and represent an integer between 0 and 1000.
	Each {amount} consist of digits, and represent an integer between 0 and 2000.

```java
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
```
