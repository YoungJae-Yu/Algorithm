class Solution {
    public int balancedString(String s) {
        int n = s.length();
        int k = n / 4;
        int[] count = new int[128];
        for (char c : s.toCharArray()) count[c]++;
        
        if (count['Q'] == k && count['W'] == k && count['E'] == k && count['R'] == k) return 0;
        
        int left = 0, res = n;
        for (int right = 0; right < n; right++) {
            count[s.charAt(right)]--;
            while (left <= right && count['Q'] <= k && count['W'] <= k && count['E'] <= k && count['R'] <= k) {
                res = Math.min(res, right - left + 1);
                count[s.charAt(left)]++;
                left++;
            }
        }
        return res;
    }
}