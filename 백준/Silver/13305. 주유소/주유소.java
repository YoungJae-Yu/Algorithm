import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); // 도시의 수
        
        long[] distances = new long[n - 1]; // 거리 배열
        long[] prices = new long[n]; // 주유소 가격 배열
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            distances[i] = Long.parseLong(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            prices[i] = Long.parseLong(st.nextToken());
        }
        
        long totalCost = 0;
        long minPrice = prices[0]; // 첫 번째 도시의 주유소 가격으로 초기화
        
        for (int i = 0; i < n - 1; i++) {
            // 현재 도시까지의 최소 주유 가격으로 거리만큼 주유
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            totalCost += minPrice * distances[i];
        }
        
        System.out.println(totalCost);
    }
}