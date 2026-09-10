# 187. Repeated DNA Sequences

https://leetcode.com/problems/repeated-dna-sequences/

The DNA sequence is composed of a series of nucleotides abbreviated as &#39;A&#39;, &#39;C&#39;, &#39;G&#39;, and &#39;T&#39;.

	For example, &quot;ACGAATTCCG&quot; is a DNA sequence.

When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.

 
Example 1:
Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]
Example 2:
Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]

 
Constraints:

	1 <= s.length <= 105
	s[i] is either &#39;A&#39;, &#39;C&#39;, &#39;G&#39;, or &#39;T&#39;.

```java
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() <= 10) return result;
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0); map.put('C', 1); map.put('G', 2); map.put('T', 3);
        int n = s.length();
        int mask = (1 << 20) - 1;
        int hash = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hash = ((hash << 2) & mask) | map.get(s.charAt(i));
            if (i >= 9) {
                int c = count.getOrDefault(hash, 0);
                if (c == 1) result.add(s.substring(i - 9, i + 1));
                count.put(hash, c + 1);
            }
        }
        return result;
    }
}
```
