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