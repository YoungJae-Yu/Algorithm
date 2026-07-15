# 1140. Distant Barcodes

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/distant-barcodes/ |

## 문제

In a warehouse, there is a row of barcodes, where the ith barcode is barcodes[i].

Rearrange the barcodes so that no two adjacent barcodes are equal. You may return any answer, and it is guaranteed an answer exists.

 
Example 1:
Input: barcodes = [1,1,1,2,2,2]
Output: [2,1,2,1,2,1]
Example 2:
Input: barcodes = [1,1,1,1,2,2,3,3]
Output: [1,3,1,3,1,2,1,2]

 
Constraints:

	1 <= barcodes.length <= 10000
	1 <= barcodes[i] <= 10000

## 풀이

```java
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        var freq = new java.util.HashMap<Integer, Integer>();
        for (int b : barcodes) {
            freq.merge(b, 1, Integer::sum);
        }

        var pq = new java.util.PriorityQueue<int[]>((a, b) -> b[1] - a[1]);
        for (var entry : freq.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        int[] result = new int[barcodes.length];
        int idx = 0;

        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (idx == 0 || result[idx - 1] != first[0]) {
                result[idx++] = first[0];
                if (--first[1] > 0) pq.offer(first);
            } else {
                int[] second = pq.poll();
                result[idx++] = second[0];
                if (--second[1] > 0) pq.offer(second);
                pq.offer(first);
            }
        }

        return result;
    }
}
```
