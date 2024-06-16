import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        
        String[] minusSplit = expression.split("-");
        
        int result = 0;
        for (int i = 0; i < minusSplit.length; i++) {
            String[] plusSplit = minusSplit[i].split("\\+");
            
            int sum = 0;
            for (String num : plusSplit) {
                sum += Integer.parseInt(num);
            }
            
            if (i == 0) {
                result += sum;
            } else {
                result -= sum;
            }
        }
        
        System.out.println(result);
    }
}