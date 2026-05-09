import java.util.*;

class TimeMap {

    private final Map<String, List<int[]>> timestampMap;
    private final Map<String, List<String>> valueMap;

    public TimeMap() {
        timestampMap = new HashMap<>();
        valueMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timestampMap.computeIfAbsent(key, k -> new ArrayList<>()).add(new int[]{timestamp});
        valueMap.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }

    public String get(String key, int timestamp) {
        if (!timestampMap.containsKey(key)) return "";

        List<int[]> timestamps = timestampMap.get(key);
        int left = 0, right = timestamps.size() - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (timestamps.get(mid)[0] <= timestamp) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result == -1 ? "" : valueMap.get(key).get(result);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */