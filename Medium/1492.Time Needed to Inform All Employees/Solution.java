class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> subordinates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            subordinates.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                subordinates.get(manager[i]).add(i);
            }
        }
        
        return dfs(headID, subordinates, informTime);
    }
    
    private int dfs(int emp, List<List<Integer>> subordinates, int[] informTime) {
        int maxTime = 0;
        for (int sub : subordinates.get(emp)) {
            maxTime = Math.max(maxTime, dfs(sub, subordinates, informTime));
        }
        return informTime[emp] + maxTime;
    }
}