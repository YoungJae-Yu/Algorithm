class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> edgeCount = new HashMap<>();
        
        for (List<Integer> row : wall) {
            int sum = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                edgeCount.merge(sum, 1, Integer::sum);
            }
        }
        
        int maxEdges = edgeCount.values().stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
        
        return wall.size() - maxEdges;
    }
}