import java.util.Scanner;

public class Main {

    static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    static int[] numbers;

    static int[] operators = new int[4]; // +, -, *, /

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        numbers = new int[N];

        for (int i = 0; i < N; i++) {

            numbers[i] = sc.nextInt();

        }

        for (int i = 0; i < 4; i++) {

            operators[i] = sc.nextInt();

        }

        dfs(numbers[0], 1);

        

        System.out.println(max);

        System.out.println(min);

    }

    public static void dfs(int num, int idx) {

        if (idx == N) {

            max = Math.max(max, num);

            min = Math.min(min, num);

            return;

        }

        for (int i = 0; i < 4; i++) {

            if (operators[i] > 0) {

                operators[i]--;

                

                switch (i) {

                    case 0: dfs(num + numbers[idx], idx + 1); break;

                    case 1: dfs(num - numbers[idx], idx + 1); break;

                    case 2: dfs(num * numbers[idx], idx + 1); break;

                    case 3: dfs(num / numbers[idx], idx + 1); break;

                }

                

                operators[i]++;

            }

        }

    }

}