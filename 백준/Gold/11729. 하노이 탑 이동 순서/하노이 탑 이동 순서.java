import java.util.Scanner;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        sb.append((int) (Math.pow(2, N) - 1)).append('\n');

        hanoi(N, 1, 2, 3);

        System.out.println(sb);

    }

    // N: 옮길 원판의 수, start: 출발지, mid: 경유지, to: 목적지

    public static void hanoi(int N, int start, int mid, int to) {

        if (N == 1) {

            sb.append(start + " " + to + "\n");

            return;

        }

        hanoi(N - 1, start, to, mid); // N-1개를 A에서 B로 이동

        sb.append(start + " " + to + "\n"); // 가장 큰 원반을 C로 이동

        hanoi(N - 1, mid, start, to); // N-1개를 B에서 C로 이동

    }

}