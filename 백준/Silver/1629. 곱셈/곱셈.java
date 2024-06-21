import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);
        long C = Long.parseLong(input[2]);
        
        System.out.println(modularExponentiation(A, B, C));
    }

    public static long modularExponentiation(long base, long exponent, long mod) {
        if (exponent == 0) {
            return 1;
        }
        
        long half = modularExponentiation(base, exponent / 2, mod);
        long result = (half * half) % mod;
        
        if (exponent % 2 != 0) {
            result = (result * base) % mod;
        }
        
        return result;
    }
}