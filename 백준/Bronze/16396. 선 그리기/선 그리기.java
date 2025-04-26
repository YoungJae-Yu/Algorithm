import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<int[]> segments = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            segments.add(new int[]{start, end});
        }

        segments.sort(Comparator.comparingInt(a -> a[0]));

        int totalLength = 0;
        int currentStart = segments.get(0)[0];
        int currentEnd = segments.get(0)[1];

        for (int i = 1; i < N; i++) {
            int start = segments.get(i)[0];
            int end = segments.get(i)[1];

            if (start <= currentEnd) {
                currentEnd = Math.max(currentEnd, end);
            } else {
                totalLength += currentEnd - currentStart;
                currentStart = start;
                currentEnd = end;
            }
        }

        totalLength += currentEnd - currentStart;
        System.out.println(totalLength);
    }
}