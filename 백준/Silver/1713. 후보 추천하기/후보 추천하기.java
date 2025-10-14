import java.io.*;
import java.util.*;

public class Main {
    static class Candidate {
        int id, count, time;
        Candidate(int id, int count, int time) {
            this.id = id; this.count = count; this.time = time;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Candidate> list = new ArrayList<>();
        for (int t = 0; t < K; t++) {
            int id = Integer.parseInt(st.nextToken());
            boolean found = false;
            for (Candidate c : list) {
                if (c.id == id) {
                    c.count++;
                    found = true;
                    break;
                }
            }
            if (found) continue;
            if (list.size() < N) {
                list.add(new Candidate(id,1,t));
            } else {
                int idx = 0;
                for (int i = 1; i < list.size(); i++) {
                    Candidate a = list.get(i);
                    Candidate b = list.get(idx);
                    if (a.count < b.count || (a.count == b.count && a.time < b.time)) {
                        idx = i;
                    }
                }
                list.remove(idx);
                list.add(new Candidate(id,1,t));
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) res[i] = list.get(i).id;
        Arrays.sort(res);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i>0) sb.append(' ');
            sb.append(res[i]);
        }
        System.out.println(sb.toString());
    }
}