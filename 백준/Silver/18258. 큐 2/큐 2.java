import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static Deque<Integer> deque = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int nOfCommand = 0;
        while (nOfCommand < N) {
            StringTokenizer command = new StringTokenizer(br.readLine());
            switch (command.nextToken()) {
                case "push":
                    deque.addLast(Integer.parseInt(command.nextToken()));
                    break;
                case "pop":
                    if(deque.isEmpty()) { 
                        bw.write("-1\n"); 
                    }
                    else { 
                        bw.write(Integer.toString(deque.pollFirst()) + "\n"); 
                    }
                    break;
                case "size":
                    bw.write(Integer.toString(deque.size()) + "\n");
                    break;
                case "empty":
                    if(deque.isEmpty()) { 
                        bw.write("1\n"); 
                    }
                    else { 
                        bw.write("0\n"); 
                    }
                    break;
                case "front":
                    if(deque.isEmpty()) { 
                        bw.write("-1\n"); 
                    }
                    else { 
                        bw.write(Integer.toString(deque.peekFirst()) + "\n"); 
                    }
                    break;
                case "back":
                    if(deque.isEmpty()) { 
                        bw.write("-1\n"); 
                    }
                    else { 
                        bw.write(Integer.toString(deque.peekLast()) + "\n"); 
                    }
                    break;
            }
            nOfCommand++;
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
