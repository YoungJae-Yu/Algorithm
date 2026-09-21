class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int n = s.length(), m = p.length();
        if (m > n) return result;
        int[] pCount = new int[26], sCount = new int[26];
        for (int i = 0; i < m; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(pCount, sCount)) result.add(0);
        for (int i = m; i < n; i++) {
            sCount[s.charAt(i) - 'a']++;
            sCount[s.charAt(i - m) - 'a']--;
            if (Arrays.equals(pCount, sCount)) result.add(i - m + 1);
        }
        return result;
    }
}