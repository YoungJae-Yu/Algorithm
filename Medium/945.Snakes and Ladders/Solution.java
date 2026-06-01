class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n * n;
        
        boolean[] visited = new boolean[target + 1];
        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        
        queue.offer(1);
        visited[1] = true;
        int moves = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                
                if (curr == target) return moves;
                
                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;
                    if (next > target) break;
                    
                    int[] pos = getPosition(next, n);
                    int row = pos[0], col = pos[1];
                    
                    if (board[row][col] != -1) {
                        next = board[row][col];
                    }
                    
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            moves++;
        }
        
        return -1;
    }
    
    private int[] getPosition(int num, int n) {
        int row = (num - 1) / n;
        int col = (num - 1) % n;
        
        if (row % 2 == 1) {
            col = n - 1 - col;
        }
        
        return new int[]{n - 1 - row, col};
    }
}