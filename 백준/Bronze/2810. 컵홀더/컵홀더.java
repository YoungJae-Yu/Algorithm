import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String seats = sc.next();
        sc.close();

        int cupHolderCount = N + 1; 
        int coupleSeatCount = seats.split("LL", -1).length - 1; 

        cupHolderCount -= coupleSeatCount; 

        System.out.println(Math.min(N, cupHolderCount));
    }
}