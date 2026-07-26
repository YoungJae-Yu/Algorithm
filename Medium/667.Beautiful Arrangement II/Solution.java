class Solution {
    public int[] constructArray(int n, int k) {
        int[] answer = new int[n];
        int lo = 1, hi = k + 1;
        
        for (int i = 0; i <= k; i++) {
            answer[i] = (i % 2 == 0) ? lo++ : hi--;
        }
        
        for (int i = k + 1; i < n; i++) {
            answer[i] = i + 1;
        }
        
        return answer;
    }
}