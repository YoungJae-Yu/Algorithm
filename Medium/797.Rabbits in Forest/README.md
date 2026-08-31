# 797. Rabbits in Forest

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/rabbits-in-forest/ |

## 문제

There is a forest with an unknown number of rabbits. We asked n rabbits &quot;How many other rabbits have the same color as you?&quot; and collected the answers in an integer array answers where answers[i] is the answer of the ith rabbit.

Given the array answers, return the minimum number of rabbits that could be in the forest.

 
Example 1:

Input: answers = [1,1,2]
Output: 5
Explanation:
The two rabbits that answered &quot;1&quot; could both be the same color, say red.
The rabbit that answered &quot;2&quot; can&#39;t be red or the answers would be inconsistent.
Say the rabbit that answered &quot;2&quot; was blue.
Then there should be 2 other blue rabbits in the forest that didn&#39;t answer into the array.
The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn&#39;t.

Example 2:

Input: answers = [10,10,10]
Output: 11

 
Constraints:

	1 <= answers.length <= 1000
	0 <= answers[i] < 1000

## 풀이

```java
class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int ans : answers) {
            countMap.merge(ans, 1, Integer::sum);
        }
        
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int answer = entry.getKey();
            int count = entry.getValue();
            int groupSize = answer + 1;
            int groups = (count + groupSize - 1) / groupSize;
            total += groups * groupSize;
        }
        
        return total;
    }
}
```
