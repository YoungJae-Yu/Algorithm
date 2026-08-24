class Solution {
    public int rotatedDigits(int n) {
        int[] map = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};
        int count = 0;
        
        for (int i = 1; i <= n; i++) {
            if (isGood(i, map)) count++;
        }
        
        return count;
    }
    
    private boolean isGood(int x, int[] map) {
        boolean different = false;
        
        while (x > 0) {
            int digit = x % 10;
            if (map[digit] == -1) return false;
            if (map[digit] == 1) different = true;
            x /= 10;
        }
        
        return different;
    }
}