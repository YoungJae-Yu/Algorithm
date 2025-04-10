import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 소비

        String[] patterns = {
            "TTT", "TTH", "THT", "THH",
            "HTT", "HTH", "HHT", "HHH"
        };

        for (int t = 0; t < testCases; t++) {
            String sequence = scanner.nextLine();
            int[] counts = new int[8];

            for (int i = 0; i <= 37; i++) {
                String sub = sequence.substring(i, i + 3);
                for (int j = 0; j < 8; j++) {
                    if (sub.equals(patterns[j])) {
                        counts[j]++;
                        break;
                    }
                }
            }

            for (int count : counts) {
                System.out.print(count + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}