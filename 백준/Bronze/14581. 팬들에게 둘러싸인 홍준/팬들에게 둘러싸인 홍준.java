import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();
        scanner.close();

        System.out.println(":fan::fan::fan:");
        System.out.println(":fan::" + id + "::fan:");
        System.out.println(":fan::fan::fan:");
    }
}