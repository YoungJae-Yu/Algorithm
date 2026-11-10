import java.util.*;

class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        int size = 1 << n;
        List<Integer> res = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            res.add(start ^ i ^ (i >> 1));
        }
        return res;
    }
}