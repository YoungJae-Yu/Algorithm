import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int L = scanner.nextInt();
        
        int time = (L + 4) / 5;
        System.out.println(time);
    }
}