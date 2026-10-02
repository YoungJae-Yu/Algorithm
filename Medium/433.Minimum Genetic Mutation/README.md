# 433. Minimum Genetic Mutation

https://leetcode.com/problems/minimum-genetic-mutation/

A gene string can be represented by an 8-character long string, with choices from &#39;A&#39;, &#39;C&#39;, &#39;G&#39;, and &#39;T&#39;.

Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene where one mutation is defined as one single character changed in the gene string.

	For example, &quot;AACCGGTT&quot; --> &quot;AACCGGTA&quot; is one mutation.

There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.

Given the two gene strings startGene and endGene and the gene bank bank, return the minimum number of mutations needed to mutate from startGene to endGene. If there is no such a mutation, return -1.

Note that the starting point is assumed to be valid, so it might not be included in the bank.

 
Example 1:

Input: startGene = &quot;AACCGGTT&quot;, endGene = &quot;AACCGGTA&quot;, bank = [&quot;AACCGGTA&quot;]
Output: 1

Example 2:

Input: startGene = &quot;AACCGGTT&quot;, endGene = &quot;AAACGGTA&quot;, bank = [&quot;AACCGGTA&quot;,&quot;AACCGCTA&quot;,&quot;AAACGGTA&quot;]
Output: 2

 
Constraints:

	0 <= bank.length <= 10
	startGene.length == endGene.length == bank[i].length == 8
	startGene, endGene, and bank[i] consist of only the characters [&#39;A&#39;, &#39;C&#39;, &#39;G&#39;, &#39;T&#39;].

```java
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) return -1;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(startGene);
        visited.add(startGene);
        int steps = 0;
        char[] chars = {'A', 'C', 'G', 'T'};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endGene)) return steps;
                char[] arr = curr.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char old = arr[j];
                    for (char c : chars) {
                        if (c == old) continue;
                        arr[j] = c;
                        String next = new String(arr);
                        if (bankSet.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    arr[j] = old;
                }
            }
            steps++;
        }
        return -1;
    }
}
```
