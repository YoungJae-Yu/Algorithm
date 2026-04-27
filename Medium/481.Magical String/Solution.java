class Solution {
    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;

        int[] s = new int[n + 1];
        s[0] = 1;
        s[1] = 2;
        s[2] = 2;

        int head = 2;
        int tail = 3;
        int num = 1;
        int count = 1;

        while (tail < n) {
            int repeat = s[head++];
            for (int i = 0; i < repeat && tail < n; i++) {
                s[tail++] = num;
            }
            num = num == 1 ? 2 : 1;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 1) result++;
        }
        return result;
    }
}