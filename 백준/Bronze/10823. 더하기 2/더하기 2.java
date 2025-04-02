import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // Read all input lines until null
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        
        // Split by comma and calculate sum
        String[] numbers = sb.toString().split(",");
        long sum = 0;  // Using long to handle potentially large sums
        
        for (String num : numbers) {
            if (!num.isEmpty()) {  // Skip empty strings
                sum += Integer.parseInt(num);
            }
        }
        
        System.out.println(sum);
    }
}