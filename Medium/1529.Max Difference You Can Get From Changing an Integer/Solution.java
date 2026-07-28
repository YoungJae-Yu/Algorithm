class Solution {
    public int maxDiff(int num) {
        String s = String.valueOf(num);
        
        String maxStr = s;
        for (char c : s.toCharArray()) {
            if (c != '9') {
                maxStr = s.replace(c, '9');
                break;
            }
        }
        
        String minStr = s;
        char first = s.charAt(0);
        if (first != '1') {
            minStr = s.replace(first, '1');
        } else {
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c != '0' && c != '1') {
                    minStr = s.replace(c, '0');
                    break;
                }
            }
        }
        
        return Integer.parseInt(maxStr) - Integer.parseInt(minStr);
    }
}