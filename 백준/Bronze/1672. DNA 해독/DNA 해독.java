import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine(); // 첫 번째 줄의 N은 사용하지 않으므로 읽기만 합니다.
        char[] dna = br.readLine().toCharArray();

        for (int i = dna.length - 1; i > 0; i--) {
            dna[i - 1] = combine(dna[i - 1], dna[i]);
        }

        System.out.println(dna[0]);
    }

    private static char combine(char a, char b) {
        if (a == b) return a;
        if ((a == 'A' && b == 'G') || (a == 'G' && b == 'A')) return 'C';
        if ((a == 'A' && b == 'C') || (a == 'C' && b == 'A')) return 'A';
        if ((a == 'A' && b == 'T') || (a == 'T' && b == 'A')) return 'G';
        if ((a == 'G' && b == 'C') || (a == 'C' && b == 'G')) return 'T';
        if ((a == 'G' && b == 'T') || (a == 'T' && b == 'G')) return 'A';
        if ((a == 'C' && b == 'T') || (a == 'T' && b == 'C')) return 'G';
        return ' ';
    }
}