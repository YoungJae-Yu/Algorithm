# 1561. Rearrange Words in a Sentence

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/rearrange-words-in-a-sentence/ |

## 문제

Given a sentence text (A sentence is a string of space-separated words) in the following format:

	First letter is in upper case.
	Each word in text are separated by a single space.

Your task is to rearrange the words in text such that all words are rearranged in an increasing order of their lengths. If two words have the same length, arrange them in their original order.

Return the new text following the format shown above.

 
Example 1:

Input: text = &quot;Leetcode is cool&quot;
Output: &quot;Is cool leetcode&quot;
Explanation: There are 3 words, &quot;Leetcode&quot; of length 8, &quot;is&quot; of length 2 and &quot;cool&quot; of length 4.
Output is ordered by length and the new first word starts with capital letter.

Example 2:

Input: text = &quot;Keep calm and code on&quot;
Output: &quot;On and keep calm code&quot;
Explanation: Output is ordered as follows:
&quot;On&quot; 2 letters.
&quot;and&quot; 3 letters.
&quot;keep&quot; 4 letters in case of tie order by position in original text.
&quot;calm&quot; 4 letters.
&quot;code&quot; 4 letters.

Example 3:

Input: text = &quot;To be or not to be&quot;
Output: &quot;To be or to be not&quot;

 
Constraints:

	text begins with a capital letter and then contains lowercase letters and single space between words.
	1 <= text.length <= 10^5

## 풀이

```java
class Solution {
    public String arrangeWords(String text) {
        String[] words = text.split(" ");
        words[0] = words[0].toLowerCase();
        
        java.util.Arrays.sort(words, java.util.Comparator.comparingInt(String::length).thenComparingInt(w -> 0));
        
        String[] wordsWithIndex = new String[words.length];
        String lower = text.toLowerCase();
        String[] original = lower.split(" ");
        
        record IndexedWord(String word, int index) {}
        
        var indexed = new IndexedWord[original.length];
        for (int i = 0; i < original.length; i++) {
            indexed[i] = new IndexedWord(original[i], i);
        }
        
        java.util.Arrays.sort(indexed, java.util.Comparator
            .comparingInt((IndexedWord iw) -> iw.word().length())
            .thenComparingInt(IndexedWord::index));
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indexed.length; i++) {
            if (i == 0) {
                String w = indexed[i].word();
                sb.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1));
            } else {
                sb.append(' ').append(indexed[i].word());
            }
        }
        
        return sb.toString();
    }
}
```
