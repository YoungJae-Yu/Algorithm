class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        
        int result = check(tops[0], tops, bottoms, n);
        if (result != -1) return result;
        
        return check(bottoms[0], tops, bottoms, n);
    }
    
    private int check(int target, int[] tops, int[] bottoms, int n) {
        int rotateTop = 0, rotateBottom = 0;
        
        for (int i = 0; i < n; i++) {
            if (tops[i] != target && bottoms[i] != target) {
                return -1;
            } else if (tops[i] != target) {
                rotateTop++;
            } else if (bottoms[i] != target) {
                rotateBottom++;
            }
        }
        
        return Math.min(rotateTop, rotateBottom);
    }
}