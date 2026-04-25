import java.util.*;

class Solution {
    private final Map<String, String> parent = new HashMap<>();
    private final Map<String, String> emailToName = new HashMap<>();

    private String find(String x) {
        parent.putIfAbsent(x, x);
        if (!parent.get(x).equals(x)) {
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }

    private void union(String x, String y) {
        String px = find(x), py = find(y);
        if (!px.equals(py)) {
            parent.put(px, py);
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        for (var account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailToName.put(email, name);
                parent.putIfAbsent(email, email);
                union(firstEmail, email);
            }
        }

        Map<String, TreeSet<String>> groups = new HashMap<>();
        for (String email : emailToName.keySet()) {
            String root = find(email);
            groups.computeIfAbsent(root, k -> new TreeSet<>()).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for (var entry : groups.entrySet()) {
            List<String> merged = new ArrayList<>();
            merged.add(emailToName.get(entry.getKey()));
            merged.addAll(entry.getValue());
            result.add(merged);
        }

        return result;
    }
}