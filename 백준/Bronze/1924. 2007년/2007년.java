import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.close();
        
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String[] daysOfWeek = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };
        
        int totalDays = 0;
        for (int i = 0; i < x - 1; i++) {
            totalDays += daysInMonth[i];
        }
        totalDays += y - 1;
        
        System.out.println(daysOfWeek[totalDays % 7]);
    }
}