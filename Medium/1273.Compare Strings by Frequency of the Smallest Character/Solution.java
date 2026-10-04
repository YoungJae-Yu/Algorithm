class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int n = words.length;
        int[] wf = new int[n];
        for (int i = 0; i < n; i++) wf[i] = f(words[i]);
        java.util.Arrays.sort(wf);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int qf = f(queries[i]);
            int lo = 0, hi = n;
            while (lo < hi) {
                int mid = (lo + hi) >>> 1;
                if (wf[mid] <= qf) lo = mid + 1;
                else hi = mid;
            }
            ans[i] = n - lo;
        }
        return ans;
    }

    private int f(String s) {
        char min = 'z' + 1;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c < min) {
                min = c;
                count = 1;
            } else if (c == min) {
                count++;
            }
        }
        return count;
    }
}