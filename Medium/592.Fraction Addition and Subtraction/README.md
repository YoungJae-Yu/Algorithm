# 592. Fraction Addition and Subtraction

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/fraction-addition-and-subtraction/ |

## 문제

Given a string expression representing an expression of fraction addition and subtraction, return the calculation result in string format.

The final result should be an irreducible fraction. If your final result is an integer, change it to the format of a fraction that has a denominator 1. So in this case, 2 should be converted to 2/1.

 
Example 1:

Input: expression = &quot;-1/2+1/2&quot;
Output: &quot;0/1&quot;

Example 2:

Input: expression = &quot;-1/2+1/2+1/3&quot;
Output: &quot;1/3&quot;

Example 3:

Input: expression = &quot;1/3-1/2&quot;
Output: &quot;-1/6&quot;

 
Constraints:

	The input string only contains &#39;0&#39; to &#39;9&#39;, &#39;/&#39;, &#39;+&#39; and &#39;-&#39;. So does the output.
	Each fraction (input and output) has the format &plusmn;numerator/denominator. If the first input fraction or the output is positive, then &#39;+&#39; will be omitted.
	The input only contains valid irreducible fractions, where the numerator and denominator of each fraction will always be in the range [1, 10]. If the denominator is 1, it means this fraction is actually an integer in a fraction format defined above.
	The number of given fractions will be in the range [1, 10].
	The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.

## 풀이

```java
class Solution {
    public String fractionAddition(String expression) {
        if (!expression.isEmpty() && expression.charAt(0) != '-') {
            expression = "+" + expression;
        }
        
        long numerator = 0;
        long denominator = 1;
        
        int i = 0;
        int n = expression.length();
        
        while (i < n) {
            int sign = expression.charAt(i) == '+' ? 1 : -1;
            i++;
            
            int j = i;
            while (j < n && expression.charAt(j) != '+' && expression.charAt(j) != '-') {
                j++;
            }
            
            String fraction = expression.substring(i, j);
            String[] parts = fraction.split("/");
            long num = Long.parseLong(parts[0]);
            long den = Long.parseLong(parts[1]);
            
            numerator = numerator * den + sign * num * denominator;
            denominator = denominator * den;
            
            long gcd = gcd(Math.abs(numerator), Math.abs(denominator));
            numerator /= gcd;
            denominator /= gcd;
            
            i = j;
        }
        
        return numerator + "/" + denominator;
    }
    
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
```
