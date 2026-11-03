class Solution {
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        char[] chars = new char[n];
        int[] counts = new int[n];
        int top = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            chars[top] = c;
            counts[top] = (top > 0 && chars[top - 1] == c) ? counts[top - 1] + 1 : 1;
            if (counts[top] == k) {
                top -= k - 1;
            } else {
                top++;
            }
        }
        return new String(chars, 0, top);
    }
}