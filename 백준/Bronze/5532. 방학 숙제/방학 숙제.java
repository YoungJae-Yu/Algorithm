import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt(); // 방학일 수
        int A = sc.nextInt(); // 국어 총 페이지 수
        int B = sc.nextInt(); // 수학 총 페이지 수
        int C = sc.nextInt(); // 하루에 풀 수 있는 국어 페이지 수
        int D = sc.nextInt(); // 하루에 풀 수 있는 수학 페이지 수

        int koreanDays = (int) Math.ceil((double) A / C);
        int mathDays = (int) Math.ceil((double) B / D);

        int studyDays = Math.max(koreanDays, mathDays);
        System.out.println(L - studyDays);

        sc.close();
    }
}