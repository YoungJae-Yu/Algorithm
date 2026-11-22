class Solution {
    private int[] parent = new int[26];

    private int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String e : equations) {
            if (e.charAt(1) == '=') {
                int a = find(e.charAt(0) - 'a');
                int b = find(e.charAt(3) - 'a');
                if (a != b) {
                    parent[a] = b;
                }
            }
        }
        for (String e : equations) {
            if (e.charAt(1) == '!') {
                if (find(e.charAt(0) - 'a') == find(e.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }
}