class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] path : paths) {
            adj.get(path[0]).add(path[1]);
            adj.get(path[1]).add(path[0]);
        }
        
        int[] answer = new int[n + 1];
        
        for (int garden = 1; garden <= n; garden++) {
            boolean[] used = new boolean[5];
            for (int neighbor : adj.get(garden)) {
                if (answer[neighbor] != 0) {
                    used[answer[neighbor]] = true;
                }
            }
            for (int flower = 1; flower <= 4; flower++) {
                if (!used[flower]) {
                    answer[garden] = flower;
                    break;
                }
            }
        }
        
        return Arrays.copyOfRange(answer, 1, n + 1);
    }
}