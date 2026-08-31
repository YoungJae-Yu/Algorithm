class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int ans : answers) {
            countMap.merge(ans, 1, Integer::sum);
        }
        
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int answer = entry.getKey();
            int count = entry.getValue();
            int groupSize = answer + 1;
            int groups = (count + groupSize - 1) / groupSize;
            total += groups * groupSize;
        }
        
        return total;
    }
}