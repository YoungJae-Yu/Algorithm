import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 파일 이름의 개수
        String[] files = new String[N];

        for (int i = 0; i < N; i++) {
            files[i] = scanner.next(); // 파일 이름 입력 받기
        }

        int fileLength = files[0].length(); // 파일 이름의 길이
        StringBuilder pattern = new StringBuilder(); // 패턴을 저장할 StringBuilder

        // 파일 이름의 문자열을 하나씩 비교하여 패턴 구성
        for (int i = 0; i < fileLength; i++) {
            char current = files[0].charAt(i); // 첫 번째 파일 이름의 i번째 문자
            boolean same = true; // 모든 파일 이름이 동일한 문자열을 가지고 있는지 여부

            for (int j = 1; j < N; j++) {
                if (current != files[j].charAt(i)) {
                    same = false;
                    break;
                }
            }

            // 모든 파일 이름이 동일한 문자열을 가지고 있으면 해당 문자열을 패턴에 추가
            if (same) {
                pattern.append(current);
            } else {
                pattern.append('?'); // 다른 문자열이 있는 경우 '?'를 패턴에 추가
            }
        }

        System.out.println(pattern.toString());
    }
}
