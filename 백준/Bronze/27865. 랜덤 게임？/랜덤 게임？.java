import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String response;
        while (true) {
            System.out.println("? 1");
            System.out.flush();
            response = br.readLine();
            if ("Y".equals(response)) break;
        }
        System.out.println("! 1");
        System.out.flush();
    }
}