class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        
        int result = 10;
        int availableDigits = 9;
        int currentCount = 9;
        
        for (int i = 2; i <= n; i++) {
            currentCount *= availableDigits;
            result += currentCount;
            availableDigits--;
        }
        
        return result;
    }
}