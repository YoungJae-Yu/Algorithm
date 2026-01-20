import java.io.*;
import java.util.*;

public class Main {
    static class Event {
        int x;
        int h;
        Event(int x, int h) {
            this.x = x;
            this.h = h;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        Event[] events = new Event[2 * N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            events[2*i] = new Event(L, -H);
            events[2*i+1] = new Event(R, H);
        }
        Arrays.sort(events, new Comparator<Event>() {
            public int compare(Event a, Event b) {
                if (a.x != b.x) return Integer.compare(a.x, b.x);
                return Integer.compare(a.h, b.h);
            }
        });

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1);
        StringBuilder sb = new StringBuilder();
        int prev = 0;

        for (Event e : events) {
            if (e.h < 0) {
                int hh = -e.h;
                map.put(hh, map.getOrDefault(hh, 0) + 1);
            } else {
                int cnt = map.get(e.h);
                if (cnt == 1) map.remove(e.h);
                else map.put(e.h, cnt - 1);
            }
            int cur = map.lastKey();
            if (cur != prev) {
                sb.append(e.x).append(" ").append(cur).append(" ");
                prev = cur;
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length()-1) == ' ') sb.setLength(sb.length()-1);
        System.out.println(sb.toString());
    }
}