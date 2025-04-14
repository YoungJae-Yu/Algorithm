import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 세로 길이
        int M = Integer.parseInt(st.nextToken()); // 가로 길이

        char[][] original = new char[N][M];
        for (int i = 0; i < N; i++) {
            original[i] = br.readLine().toCharArray();
        }

        // 문자 변환 맵
        HashMap<Character, Character> rotateMap = new HashMap<>();
        rotateMap.put('.', '.');
        rotateMap.put('O', 'O');
        rotateMap.put('-', '|');
        rotateMap.put('|', '-');
        rotateMap.put('/', '\\');
        rotateMap.put('\\', '/');
        rotateMap.put('^', '<');
        rotateMap.put('<', 'v');
        rotateMap.put('v', '>');
        rotateMap.put('>', '^');

        char[][] rotated = new char[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char ch = original[i][j];
                char rotatedChar = rotateMap.getOrDefault(ch, ch);
                rotated[M - j - 1][i] = rotatedChar;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(rotated[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}