import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        long f;
        long x;
        Node(long f, long x) { this.f = f; this.x = x; }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < L; i++) set.add(Long.parseLong(st.nextToken()));
        List<Long> s = new ArrayList<>(set);
        int n = Integer.parseInt(br.readLine().trim());
        List<Node> cand = new ArrayList<>();
        for (long v : s) cand.add(new Node(0, v));
        for (int idx = 0; idx < s.size(); idx++) {
            long prev = (idx == 0) ? 0L : s.get(idx - 1);
            long next = s.get(idx);
            long m = next - prev - 1;
            if (m <= 0) continue;
            int maxAdd = (int)Math.min(m, n);
            int added = 0;
            for (long t = 1; added < maxAdd && t <= m; t++) {
                long l = prev + t;
                if (l <= next - 1) {
                    long p = t;
                    long f = p * (m - p + 1) - 1;
                    cand.add(new Node(f, l));
                    added++;
                    if (added == maxAdd) break;
                }
                long r = next - t;
                if (r != l && r >= prev + 1) {
                    long p = m - t + 1;
                    long f = p * (m - p + 1) - 1;
                    cand.add(new Node(f, r));
                    added++;
                }
            }
        }
        cand.sort((a, b) -> {
            if (a.f != b.f) return Long.compare(a.f, b.f);
            return Long.compare(a.x, b.x);
        });
        StringBuilder sb = new StringBuilder();
        HashSet<Long> used = new HashSet<>();
        int cnt = 0;
        for (Node node : cand) {
            if (cnt >= n) break;
            if (used.contains(node.x)) continue;
            used.add(node.x);
            if (sb.length() > 0) sb.append(' ');
            sb.append(node.x);
            cnt++;
        }
        long last = s.get(s.size() - 1);
        long cur = last + 1;
        while (cnt < n) {
            if (!used.contains(cur)) {
                if (sb.length() > 0) sb.append(' ');
                sb.append(cur);
                cnt++;
            }
            cur++;
        }
        System.out.println(sb.toString());
    }
}