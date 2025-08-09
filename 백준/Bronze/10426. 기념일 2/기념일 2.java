import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String date = sc.next();
        long n = sc.nextLong();
        LocalDate d = LocalDate.parse(date);
        LocalDate ans = d.plusDays(n - 1);
        System.out.println(ans.toString());
    }
}