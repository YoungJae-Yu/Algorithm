import java.util.List;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();
        for (String s : allowed) {
            map.computeIfAbsent(s.substring(0, 2), k -> new java.util.ArrayList<>()).add(s.charAt(2));
        }
        return solve(bottom, map);
    }

    private boolean solve(String bottom, Map<String, List<Character>> map) {
        if (bottom.length() == 1) return true;
        return build(bottom, 0, new StringBuilder(), map);
    }

    private boolean build(String bottom, int idx, StringBuilder next, Map<String, List<Character>> map) {
        if (idx == bottom.length() - 1) {
            return solve(next.toString(), map);
        }
        String key = bottom.substring(idx, idx + 2);
        List<Character> options = map.get(key);
        if (options == null) return false;
        for (char c : options) {
            next.append(c);
            if (build(bottom, idx + 1, next, map)) return true;
            next.deleteCharAt(next.length() - 1);
        }
        return false;
    }
}