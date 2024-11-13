import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        
        int remainingSlices = B - A;
        
        System.out.println(remainingSlices + " " + B);
        sc.close();
    }
}