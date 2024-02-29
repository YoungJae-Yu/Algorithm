import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        ArrayList<Integer> divisor = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            if(N % i == 0){
                divisor.add(i);
            }
        }

        if(divisor.size() < K){
            System.out.println(0);
        } else {
            System.out.println(divisor.get(K-1));
        }
    }
}
