class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        boolean[] remove = new boolean[n];
        int[] stack = new int[n];
        int top = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack[top++] = i;
            } else if (c == ')') {
                if (top > 0) {
                    top--;
                } else {
                    remove[i] = true;
                }
            }
        }
        while (top > 0) {
            remove[stack[--top]] = true;
        }
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            if (!remove[i]) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}