import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double A = Double.parseDouble(st.nextToken());
        double B = Double.parseDouble(st.nextToken());
        double C = Double.parseDouble(st.nextToken());
        st = new StringTokenizer(br.readLine());
        double I = Double.parseDouble(st.nextToken());
        double J = Double.parseDouble(st.nextToken());
        double K = Double.parseDouble(st.nextToken());

        double ratio = Math.min(Math.min(A / I, B / J), C / K);
        double rA = A - I * ratio;
        double rB = B - J * ratio;
        double rC = C - K * ratio;

        System.out.printf("%.4f %.4f %.4f", rA, rB, rC);
    }
}