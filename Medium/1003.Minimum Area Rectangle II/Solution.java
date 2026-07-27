class Solution {
    public double minAreaFreeRect(int[][] points) {
        int n = points.length;
        Set<String> pointSet = new HashSet<>();
        for (int[] p : points) {
            pointSet.add(p[0] + "," + p[1]);
        }

        double minArea = Double.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int[] p1 = points[i], p2 = points[j], p3 = points[k];

                    int[][] candidates = {
                        {p1[0], p1[1], p2[0], p2[1], p3[0], p3[1]},
                        {p2[0], p2[1], p1[0], p1[1], p3[0], p3[1]},
                        {p3[0], p3[1], p1[0], p1[1], p2[0], p2[1]}
                    };

                    for (int[] c : candidates) {
                        int ax = c[0], ay = c[1];
                        int bx = c[2], by = c[3];
                        int cx = c[4], cy = c[5];

                        int abx = bx - ax, aby = by - ay;
                        int acx = cx - ax, acy = cy - ay;

                        if (abx * acx + aby * acy != 0) continue;

                        int dx = bx + acx, dy = by + acy;

                        if (pointSet.contains(dx + "," + dy)) {
                            double area = Math.sqrt((double)(abx * abx + aby * aby)) *
                                          Math.sqrt((double)(acx * acx + acy * acy));
                            minArea = Math.min(minArea, area);
                        }
                    }
                }
            }
        }

        return minArea == Double.MAX_VALUE ? 0 : minArea;
    }
}