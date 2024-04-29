import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] papers = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            papers[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] popped = new boolean[N];
        int currentIndex = 0;
        int remaining = N;

        while (remaining > 0) {
            // 현재 풍선을 터뜨림
            popped[currentIndex] = true;
            bw.write((currentIndex + 1) + " ");
            remaining--;

            if (remaining == 0) break;

            // 다음 풍선을 찾음
            int step = papers[currentIndex];
            if (step > 0) {
                while (step > 0) {
                    currentIndex = (currentIndex + 1) % N;
                    if (!popped[currentIndex]) step--;
                }
            } else {
                while (step < 0) {
                    currentIndex = (currentIndex - 1 + N) % N;
                    if (!popped[currentIndex]) step++;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
