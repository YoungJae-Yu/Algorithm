# 539. Minimum Time Difference

| 항목 | 내용 |
|------|------|
| 난이도 | Medium |
| 링크 | https://leetcode.com/problems/minimum-time-difference/ |

## 문제

Given a list of 24-hour clock time points in &quot;HH:MM&quot; format, return the minimum minutes difference between any two time-points in the list.
 
Example 1:
Input: timePoints = ["23:59","00:00"]
Output: 1
Example 2:
Input: timePoints = ["00:00","23:59","00:00"]
Output: 0

 
Constraints:

	2 <= timePoints.length <= 2 * 104
	timePoints[i] is in the format &quot;HH:MM&quot;.

## 풀이

```java
class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] minutes = new boolean[1440];
        
        for (String time : timePoints) {
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3, 5));
            int total = h * 60 + m;
            if (minutes[total]) return 0;
            minutes[total] = true;
        }
        
        int minDiff = Integer.MAX_VALUE;
        int first = -1;
        int prev = -1;
        
        for (int i = 0; i < 1440; i++) {
            if (minutes[i]) {
                if (first == -1) {
                    first = i;
                } else {
                    minDiff = Math.min(minDiff, i - prev);
                }
                prev = i;
            }
        }
        
        minDiff = Math.min(minDiff, 1440 - prev + first);
        
        return minDiff;
    }
}
```
