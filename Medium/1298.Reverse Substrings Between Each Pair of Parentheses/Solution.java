class Solution {
    public String reverseParentheses(String s) {
        Deque<StringBuilder> stack = new ArrayDeque<>();
        StringBuilder cur = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(cur);
                cur = new StringBuilder();
            } else if (c == ')') {
                cur.reverse();
                StringBuilder prev = stack.pop();
                prev.append(cur);
                cur = prev;
            } else {
                cur.append(c);
            }
        }
        return cur.toString();
    }
}