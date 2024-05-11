import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static int[] stack;
    public static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        stack = new int[N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            switch (input.charAt(0)) {
                case '1':
                    push(Integer.parseInt(input.substring(2)));
                    break;
                case '2':
                    bw.write(pop() + "\n");
                    break;
                case '3':
                    bw.write(size + "\n");
                    break;
                case '4':
                    bw.write(empty() + "\n");
                    break;
                case '5':
                    bw.write(peek() + "\n");
                    break;
            }
        }
        bw.flush(); // 버퍼에 남아있는 데이터를 모두 출력
        bw.close(); // BufferedWriter를 닫아 자원을 해제함
    }

    public static void push(int item) {
        stack[size] = item;
        size++;
    }

    public static int pop() {
        if (size == 0) {
            return -1;
        } else {
            int res = stack[size - 1];
            size--;
            return res;
        }
    }

    public static int empty() {
        if (size == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int peek() {
        if (size == 0) {
            return -1;
        } else {
            return stack[size - 1];
        }
    }
}