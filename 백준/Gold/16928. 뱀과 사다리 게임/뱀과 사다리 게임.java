import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 사다리의 수
        int m = sc.nextInt(); // 뱀의 수
        Map<Integer, Integer> moves = new HashMap<>();
        
        for (int i = 0; i < n + m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            moves.put(start, end);
        }

        System.out.println(bfs(moves));
    }

    private static int bfs(Map<Integer, Integer> moves) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[101];
        queue.add(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int rolls = current[1];

            if (position == 100) {
                return rolls;
            }

            for (int i = 1; i <= 6; i++) {
                int nextPos = position + i;
                if (nextPos > 100) continue;

                if (moves.containsKey(nextPos)) {
                    nextPos = moves.get(nextPos);
                }

                if (!visited[nextPos]) {
                    visited[nextPos] = true;
                    queue.add(new int[]{nextPos, rolls + 1});
                }
            }
        }

        return -1; // 이 경우는 도달할 수 없는 경우를 의미합니다.
    }
}