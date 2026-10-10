import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        String s = "123456789";
        for (int len = 2; len <= 9; len++) {
            for (int start = 0; start + len <= 9; start++) {
                int num = Integer.parseInt(s.substring(start, start + len));
                if (num >= low && num <= high) {
                    res.add(num);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}