import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        List<Integer> triangleNumbers = new ArrayList<>();
        
        // 삼각수 미리 생성 (T_n ≤ 1000)
        for (int i = 1; i * (i + 1) / 2 <= 1000; i++) {
            triangleNumbers.add(i * (i + 1) / 2);
        }
        
        while (T-- > 0) {
            int K = sc.nextInt();
            boolean found = false;
            
            // 삼각수 세 개를 골라서 K를 만들 수 있는지 확인
            for (int i = 0; i < triangleNumbers.size(); i++) {
                for (int j = 0; j < triangleNumbers.size(); j++) {
                    for (int k = 0; k < triangleNumbers.size(); k++) {
                        if (triangleNumbers.get(i) + triangleNumbers.get(j) + triangleNumbers.get(k) == K) {
                            found = true;
                        }
                    }
                }
            }
            
            System.out.println(found ? 1 : 0);
        }
        
        sc.close();
    }
}