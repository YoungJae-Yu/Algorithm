class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int maxLen = Math.max(v1.length, v2.length);

        for (int i = 0; i < maxLen; i++) {
            int r1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int r2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (r1 != r2) {
                return Integer.compare(r1, r2);
            }
        }
        return 0;
    }
}