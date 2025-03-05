import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] position = new int[11]; // 소의 위치 저장 (1~10번 소 사용)
        for (int i = 1; i <= 10; i++) {
            position[i] = -1; // 초기값: 관찰되지 않음
        }
        int count = 0;

        for (int i = 0; i < n; i++) {
            int cow = sc.nextInt();
            int loc = sc.nextInt();

            if (position[cow] == -1) { 
                position[cow] = loc; // 처음 관찰된 경우 위치 저장
            } else if (position[cow] != loc) { 
                count++; // 위치가 바뀌면 횟수 증가
                position[cow] = loc; // 새로운 위치 저장
            }
        }

        System.out.println(count);
    }
}