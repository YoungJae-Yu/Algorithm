import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] order = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> plugs = new ArrayList<>();
        int unplugCount = 0;

        for (int i = 0; i < K; i++) {
            int cur = order[i];
            if (plugs.contains(cur)) {
                continue;
            }

            if (plugs.size() < N) {
                plugs.add(cur);
                continue;
            }

            int idxToRemove = -1;
            int farthestNext = -1;

            for (int j = 0; j < plugs.size(); j++) {
                int plugged = plugs.get(j);
                int nextUse = Integer.MAX_VALUE;
                for (int k2 = i + 1; k2 < K; k2++) {
                    if (order[k2] == plugged) {
                        nextUse = k2;
                        break;
                    }
                }
                if (nextUse > farthestNext) {
                    farthestNext = nextUse;
                    idxToRemove = j;
                }
            }

            plugs.remove(idxToRemove);
            plugs.add(cur);
            unplugCount++;
        }

        System.out.println(unplugCount);
    }
}