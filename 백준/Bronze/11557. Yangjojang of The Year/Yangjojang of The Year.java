import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize BufferedReader for input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read number of test cases
        int T = Integer.parseInt(br.readLine());
        
        // Process each test case
        for (int t = 0; t < T; t++) {
            // Read number of schools
            int N = Integer.parseInt(br.readLine());
            
            // Variables to track the maximum consumption and corresponding school
            String maxSchool = "";
            int maxConsumption = -1;
            
            // Process each school
            for (int n = 0; n < N; n++) {
                String line = br.readLine();
                StringTokenizer st = new StringTokenizer(line);
                
                // Extract school name and consumption
                String school = st.nextToken();
                int consumption = Integer.parseInt(st.nextToken());
                
                // Update max if current consumption is higher
                if (consumption > maxConsumption) {
                    maxConsumption = consumption;
                    maxSchool = school;
                }
            }
            
            // Output the school with the highest consumption
            System.out.println(maxSchool);
        }
    }
}