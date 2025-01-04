import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] problemsSolved = {12, 11, 11, 10, 9, 9, 9, 8, 7, 6, 6};
        int[] penalties = {1600, 894, 1327, 1311, 1004, 1178, 1357, 837, 1055, 556, 773};

        int N = scanner.nextInt();
        System.out.println(problemsSolved[N - 1] + " " + penalties[N - 1]);
    }
}