import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];
        List<Pair> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
            list.add(new Pair(i, A[i]));
        }

        Collections.sort(list, Comparator.comparingInt(o -> o.value));
        int[] P = new int[N];

        for (int i = 0; i < N; i++) {
            P[list.get(i).index] = i;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(P[i] + " ");
        }
    }

    static class Pair {
        int index, value;

        Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
