import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 포켓몬의 개수
        int M = Integer.parseInt(input[1]); // 문제의 개수
        
        // 포켓몬 이름과 번호를 저장할 HashMap
        HashMap<String, Integer> nameToIndex = new HashMap<>();
        HashMap<Integer, String> indexToName = new HashMap<>();
        
        // 포켓몬 도감 정보 입력
        for(int i = 1; i <= N; i++) {
            String pokemonName = br.readLine();
            nameToIndex.put(pokemonName, i);
            indexToName.put(i, pokemonName);
        }
        
        StringBuilder sb = new StringBuilder();
        // 문제 풀이
        for(int i = 0; i < M; i++) {
            String question = br.readLine();
            
            // 입력이 숫자인지 문자인지 판별
            if(Character.isDigit(question.charAt(0))) {
                int index = Integer.parseInt(question);
                sb.append(indexToName.get(index)).append('\n');
            } else {
                sb.append(nameToIndex.get(question)).append('\n');
            }
        }
        
        // 결과 출력
        System.out.println(sb);
    }
}
