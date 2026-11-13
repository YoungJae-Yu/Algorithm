class Solution {
    public int mctFromLeafValues(int[] arr) {
        int[] stack = new int[arr.length + 2];
        int top = 0;
        stack[top++] = Integer.MAX_VALUE;
        int res = 0;
        for (int a : arr) {
            while (stack[top - 1] <= a) {
                int mid = stack[--top];
                res += mid * Math.min(stack[top - 1], a);
            }
            stack[top++] = a;
        }
        while (top > 2) {
            res += stack[top - 1] * stack[top - 2];
            top--;
        }
        return res;
    }
}