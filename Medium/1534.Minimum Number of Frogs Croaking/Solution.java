class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] cnt = new int[5];
        int active = 0, max = 0;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char ch = croakOfFrogs.charAt(i);
            int idx = "croak".indexOf(ch);
            if (idx < 0) return -1;
            if (idx == 0) {
                cnt[0]++;
                active++;
                if (active > max) max = active;
            } else {
                if (cnt[idx - 1] == 0) return -1;
                cnt[idx - 1]--;
                if (idx == 4) active--;
                else cnt[idx]++;
            }
        }
        return active == 0 ? max : -1;
    }
}