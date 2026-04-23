class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        
        int[] s1Count = new int[26];
        int[] windowCount = new int[26];
        
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            windowCount[s2.charAt(i) - 'a']++;
        }
        
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == windowCount[i]) {
                matches++;
            }
        }
        
        for (int i = s1.length(); i < s2.length(); i++) {
            if (matches == 26) {
                return true;
            }
            
            int addIdx = s2.charAt(i) - 'a';
            int removeIdx = s2.charAt(i - s1.length()) - 'a';
            
            windowCount[addIdx]++;
            if (windowCount[addIdx] == s1Count[addIdx]) {
                matches++;
            } else if (windowCount[addIdx] == s1Count[addIdx] + 1) {
                matches--;
            }
            
            windowCount[removeIdx]--;
            if (windowCount[removeIdx] == s1Count[removeIdx]) {
                matches++;
            } else if (windowCount[removeIdx] == s1Count[removeIdx] - 1) {
                matches--;
            }
        }
        
        return matches == 26;
    }
}