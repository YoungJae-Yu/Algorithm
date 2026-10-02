class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) return -1;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(startGene);
        visited.add(startGene);
        int steps = 0;
        char[] chars = {'A', 'C', 'G', 'T'};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endGene)) return steps;
                char[] arr = curr.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char old = arr[j];
                    for (char c : chars) {
                        if (c == old) continue;
                        arr[j] = c;
                        String next = new String(arr);
                        if (bankSet.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    arr[j] = old;
                }
            }
            steps++;
        }
        return -1;
    }
}