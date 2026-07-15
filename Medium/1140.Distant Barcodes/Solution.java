class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        var freq = new java.util.HashMap<Integer, Integer>();
        for (int b : barcodes) {
            freq.merge(b, 1, Integer::sum);
        }

        var pq = new java.util.PriorityQueue<int[]>((a, b) -> b[1] - a[1]);
        for (var entry : freq.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        int[] result = new int[barcodes.length];
        int idx = 0;

        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (idx == 0 || result[idx - 1] != first[0]) {
                result[idx++] = first[0];
                if (--first[1] > 0) pq.offer(first);
            } else {
                int[] second = pq.poll();
                result[idx++] = second[0];
                if (--second[1] > 0) pq.offer(second);
                pq.offer(first);
            }
        }

        return result;
    }
}