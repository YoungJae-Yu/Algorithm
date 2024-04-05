import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aSize = Integer.parseInt(st.nextToken()); // 집합 A의 원소 개수
        int bSize = Integer.parseInt(st.nextToken()); // 집합 B의 원소 개수

        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();

        // 집합 A의 모든 원소를 setA에 추가
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aSize; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        // 집합 B의 모든 원소를 setB에 추가
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bSize; i++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }

        // 대칭 차집합의 원소 개수를 계산
        int count = 0;
        
        // setA에서 setB에 없는 원소의 개수를 세기
        for (int num : setA) {
            if (!setB.contains(num)) {
                count++;
            }
        }

        // setB에서 setA에 없는 원소의 개수를 세기
        for (int num : setB) {
            if (!setA.contains(num)) {
                count++;
            }
        }

        // 대칭 차집합의 원소 개수 출력
        System.out.println(count);
    }
}
