import java.util.*;

class Condo implements Comparable<Condo> {
    int D;
    int C;

    public Condo(int D, int C) {
        this.D = D;
        this.C = C;
    }

    @Override
    public int compareTo(Condo other) {
        if (this.C != other.C) {
            return Integer.compare(this.C, other.C);
        } else {
            return Integer.compare(this.D, other.D);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Condo> condos = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int D = scanner.nextInt();
            int C = scanner.nextInt();
            condos.add(new Condo(D, C));
        }
        Collections.sort(condos);

        int count = 0;
        int minD = Integer.MAX_VALUE;
        for (Condo condo : condos) {
            if (condo.D < minD) {
                count++;
                minD = condo.D;
            }
        }
        System.out.println(count);
    }
}