class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> result = new HashSet<>();
        
        for (int xi = 1; xi < bound; xi *= x) {
            for (int yj = 1; xi + yj <= bound; yj *= y) {
                result.add(xi + yj);
                if (y == 1) break;
            }
            if (x == 1) break;
        }
        
        return new ArrayList<>(result);
    }
}