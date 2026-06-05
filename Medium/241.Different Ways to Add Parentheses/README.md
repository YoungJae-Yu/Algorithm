# 241. Different Ways to Add Parentheses

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/different-ways-to-add-parentheses/ |

## 문제

Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. You may return the answer in any order.

The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed 104.

 
Example 1:

Input: expression = &quot;2-1-1&quot;
Output: [0,2]
Explanation:
((2-1)-1) = 0 
(2-(1-1)) = 2

Example 2:

Input: expression = &quot;2*3-4*5&quot;
Output: [-34,-14,-10,-10,10]
Explanation:
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10

 
Constraints:

	1 <= expression.length <= 20
	expression consists of digits and the operator &#39;+&#39;, &#39;-&#39;, and &#39;*&#39;.
	All the integer values in the input expression are in the range [0, 99].
	The integer values in the input expression do not have a leading &#39;-&#39; or &#39;+&#39; denoting the sign.

## 풀이

```java
import java.util.*;

class Solution {
    private final Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                for (int l : left) {
                    for (int r : right) {
                        results.add(switch (c) {
                            case '+' -> l + r;
                            case '-' -> l - r;
                            case '*' -> l * r;
                            default -> throw new IllegalArgumentException();
                        });
                    }
                }
            }
        }

        if (results.isEmpty()) {
            results.add(Integer.parseInt(expression));
        }

        memo.put(expression, results);
        return results;
    }
}
```
