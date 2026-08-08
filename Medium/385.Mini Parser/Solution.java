class Solution {
    public NestedInteger deserialize(String s) {
        if (!s.startsWith("[")) {
            return new NestedInteger(Integer.parseInt(s));
        }

        Deque<NestedInteger> stack = new ArrayDeque<>();
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            switch (c) {
                case '[' -> {
                    stack.push(new NestedInteger());
                    start = i + 1;
                }
                case ']' -> {
                    if (i > start) {
                        stack.peek().add(new NestedInteger(Integer.parseInt(s.substring(start, i))));
                    }
                    start = i + 1;
                    if (stack.size() > 1) {
                        NestedInteger top = stack.pop();
                        stack.peek().add(top);
                    }
                }
                case ',' -> {
                    if (i > start && s.charAt(start) != '[') {
                        stack.peek().add(new NestedInteger(Integer.parseInt(s.substring(start, i))));
                    }
                    start = i + 1;
                }
            }
        }

        return stack.pop();
    }
}