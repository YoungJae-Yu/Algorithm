# 1023. Time Based Key-Value Store

https://leetcode.com/problems/time-based-key-value-store/

Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key&#39;s value at a certain timestamp.

Implement the TimeMap class:

	TimeMap() Initializes the object of the data structure.
	void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
	String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns &quot;&quot;.

 
Example 1:

Input
[&quot;TimeMap&quot;, &quot;set&quot;, &quot;get&quot;, &quot;get&quot;, &quot;set&quot;, &quot;get&quot;, &quot;get&quot;]
[[], [&quot;foo&quot;, &quot;bar&quot;, 1], [&quot;foo&quot;, 1], [&quot;foo&quot;, 3], [&quot;foo&quot;, &quot;bar2&quot;, 4], [&quot;foo&quot;, 4], [&quot;foo&quot;, 5]]
Output
[null, null, &quot;bar&quot;, &quot;bar&quot;, null, &quot;bar2&quot;, &quot;bar2&quot;]

Explanation
TimeMap timeMap = new TimeMap();
timeMap.set(&quot;foo&quot;, &quot;bar&quot;, 1);  // store the key &quot;foo&quot; and value &quot;bar&quot; along with timestamp = 1.
timeMap.get(&quot;foo&quot;, 1);         // return &quot;bar&quot;
timeMap.get(&quot;foo&quot;, 3);         // return &quot;bar&quot;, since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is &quot;bar&quot;.
timeMap.set(&quot;foo&quot;, &quot;bar2&quot;, 4); // store the key &quot;foo&quot; and value &quot;bar2&quot; along with timestamp = 4.
timeMap.get(&quot;foo&quot;, 4);         // return &quot;bar2&quot;
timeMap.get(&quot;foo&quot;, 5);         // return &quot;bar2&quot;

 
Constraints:

	1 <= key.length, value.length <= 100
	key and value consist of lowercase English letters and digits.
	1 <= timestamp <= 107
	All the timestamps timestamp of set are strictly increasing.
	At most 2 * 105 calls will be made to set and get.

```java
import java.util.*;

class TimeMap {
    private final Map<String, List<int[]>> tsMap = new HashMap<>();
    private final Map<String, List<String>> valMap = new HashMap<>();

    public TimeMap() {
    }

    public void set(String key, String value, int timestamp) {
        tsMap.computeIfAbsent(key, k -> new ArrayList<>()).add(new int[]{timestamp});
        valMap.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }

    public String get(String key, int timestamp) {
        List<int[]> times = tsMap.get(key);
        if (times == null || times.isEmpty()) return "";
        int lo = 0, hi = times.size() - 1, res = -1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (times.get(mid)[0] <= timestamp) {
                res = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res == -1 ? "" : valMap.get(key).get(res);
    }
}
```
