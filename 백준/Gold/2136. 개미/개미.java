import java.io.*;
import java.util.*;

public class Main {
    static class Ant { int pos; char dir; int id; Ant(int p,char d,int i){pos=p;dir=d;id=i;} }
    static class Event { int time; char side; int idx; Event(int t,char s,int i){time=t;side=s;idx=i;} }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Ant[] ants = new Ant[N];
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine().trim());
            if (x > 0) ants[i] = new Ant(x, 'R', i + 1);
            else ants[i] = new Ant(-x, 'L', i + 1);
        }
        Arrays.sort(ants, Comparator.comparingInt(a -> a.pos));
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) dq.addLast(ants[i].id);
        Event[] events = new Event[N];
        for (int i = 0; i < N; i++) {
            int time = (ants[i].dir == 'L') ? ants[i].pos : (L - ants[i].pos);
            events[i] = new Event(time, ants[i].dir, i);
        }
        Arrays.sort(events, (a, b) -> {
            if (a.time != b.time) return Integer.compare(a.time, b.time);
            return Character.compare(a.side, b.side);
        });
        int lastId = -1;
        int lastTime = 0;
        for (Event e : events) {
            if (e.side == 'L') lastId = dq.removeFirst();
            else lastId = dq.removeLast();
            lastTime = e.time;
        }
        System.out.println(lastId + " " + lastTime);
    }
}