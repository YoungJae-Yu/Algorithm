class Solution {
    public int balancedString(String s) {
        int n = s.length();
        int target = n / 4;
        
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        
        if (count['Q'] == target && count['W'] == target && 
            count['E'] == target && count['R'] == target) {
            return 0;
        }
        
        int result = n;
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            count[s.charAt(right)]--;
            
            while (left <= right && 
                   count['Q'] <= target && count['W'] <= target && 
                   count['E'] <= target && count['R'] <= target) {
                result = Math.min(result, right - left + 1);
                count[s.charAt(left)]++;
                left++;
            }
        }
        
        return result;
    }
}