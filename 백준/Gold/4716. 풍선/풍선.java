import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    static class Team {
        int k, da, db;
        Team(int k, int da, int db) {
            this.k = k;
            this.da = da;
            this.db = db;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if (N == 0 && A == 0 && B == 0) break;

            List<Team> teams = new ArrayList<>(N);
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int k = Integer.parseInt(st.nextToken());
                int da = Integer.parseInt(st.nextToken());
                int db = Integer.parseInt(st.nextToken());
                teams.add(new Team(k, da, db));
            }

            Collections.sort(teams, new Comparator<Team>() {
                @Override
                public int compare(Team t1, Team t2) {
                    return Integer.compare(Math.abs(t2.da - t2.db), Math.abs(t1.da - t1.db));
                }
            });

            long result = 0;
            for (Team t : teams) {
                int want = t.k;
                if (t.da <= t.db) {
                    int useA = Math.min(want, A);
                    result += (long) useA * t.da;
                    A -= useA;
                    want -= useA;

                    if (want > 0) {
                        result += (long) want * t.db;
                        B -= want;
                    }
                } else {
                    int useB = Math.min(want, B);
                    result += (long) useB * t.db;
                    B -= useB;
                    want -= useB;

                    if (want > 0) {
                        result += (long) want * t.da;
                        A -= want;
                    }
                }
            }

            System.out.println(result);
        }
    }
}