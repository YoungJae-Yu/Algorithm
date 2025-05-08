import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int I = Integer.parseInt(st.nextToken());

        List<String> handles = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            handles.add(br.readLine());
        }
        Collections.sort(handles);
        System.out.println(handles.get(I - 1));
    }
}