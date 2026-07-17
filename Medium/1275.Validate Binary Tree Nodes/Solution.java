class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        
        for (int i = 0; i < n; i++) {
            int[] children = {leftChild[i], rightChild[i]};
            for (int child : children) {
                if (child == -1) continue;
                if (parent[child] != -1) return false;
                parent[child] = i;
            }
        }
        
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                if (root != -1) return false;
                root = i;
            }
        }
        
        if (root == -1) return false;
        
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(root);
        visited[root] = true;
        int count = 1;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int[] children = {leftChild[node], rightChild[node]};
            for (int child : children) {
                if (child == -1) continue;
                if (visited[child]) return false;
                visited[child] = true;
                queue.offer(child);
                count++;
            }
        }
        
        return count == n;
    }
}