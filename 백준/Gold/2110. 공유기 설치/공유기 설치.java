import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // 주어진 거리로 공유기를 설치할 수 있는지 확인하는 메서드
    private static boolean canInstall(int[] houses, int distance, int C) {
        int count = 1; // 첫 번째 집에 공유기 설치
        int lastInstalled = houses[0]; // 마지막으로 공유기 설치한 위치

        for (int i = 1; i < houses.length; i++) {
            if (houses[i] - lastInstalled >= distance) {
                count++;
                lastInstalled = houses[i];
                if (count >= C) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int C = scanner.nextInt();
        int[] houses = new int[N];

        for (int i = 0; i < N; i++) {
            houses[i] = scanner.nextInt();
        }

        Arrays.sort(houses); // 집의 좌표 정렬

        int low = 1; // 최소 거리
        int high = houses[N - 1] - houses[0]; // 최대 거리
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canInstall(houses, mid, C)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result);
    }
}