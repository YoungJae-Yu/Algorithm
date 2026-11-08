import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums1.length, m = nums2.length;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        for (int i = 0; i < Math.min(n, k); i++) {
            pq.offer(new long[]{(long) nums1[i] + nums2[0], i, 0});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            long[] cur = pq.poll();
            int i = (int) cur[1], j = (int) cur[2];
            res.add(List.of(nums1[i], nums2[j]));
            if (j + 1 < m) {
                pq.offer(new long[]{(long) nums1[i] + nums2[j + 1], i, j + 1});
            }
        }
        return res;
    }
}