# 165. Compare Version Numbers

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/compare-version-numbers/ |

## 문제

Given two version strings, version1 and version2, compare them. A version string consists of revisions separated by dots &#39;.&#39;. The value of the revision is its integer conversion ignoring leading zeros.

To compare version strings, compare their revision values in left-to-right order. If one of the version strings has fewer revisions, treat the missing revision values as 0.

Return the following:

	If version1 < version2, return -1.
	If version1 > version2, return 1.
	Otherwise, return 0.

 
Example 1:

Input: version1 = &quot;1.2&quot;, version2 = &quot;1.10&quot;

Output: -1

Explanation:

version1&#39;s second revision is &quot;2&quot; and version2&#39;s second revision is &quot;10&quot;: 2 < 10, so version1 < version2.

Example 2:

Input: version1 = &quot;1.01&quot;, version2 = &quot;1.001&quot;

Output: 0

Explanation:

Ignoring leading zeroes, both &quot;01&quot; and &quot;001&quot; represent the same integer &quot;1&quot;.

Example 3:

Input: version1 = &quot;1.0&quot;, version2 = &quot;1.0.0.0&quot;

Output: 0

Explanation:

version1 has less revisions, which means every missing revision are treated as &quot;0&quot;.

 
Constraints:

	1 <= version1.length, version2.length <= 500
	version1 and version2 only contain digits and &#39;.&#39;.
	version1 and version2 are valid version numbers.
	All the given revisions in version1 and version2 can be stored in a 32-bit integer.

## 풀이

```java
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int maxLen = Math.max(v1.length, v2.length);

        for (int i = 0; i < maxLen; i++) {
            int r1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int r2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (r1 != r2) {
                return Integer.compare(r1, r2);
            }
        }
        return 0;
    }
}
```
