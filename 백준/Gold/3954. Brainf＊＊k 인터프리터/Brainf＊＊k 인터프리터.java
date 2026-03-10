import java.io.*;
public class Main {
    static class FastReader {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') if (c == -1) return -1;
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            int val = 0;
            while (c > ' ') { val = val * 10 + (c - '0'); c = read(); }
            return val * sign;
        }
        String nextStringExact(int length) throws IOException {
            StringBuilder sb = new StringBuilder(length);
            int cnt = 0;
            while (cnt < length) {
                int c = read();
                if (c == -1) break;
                if (c == '\n' || c == '\r') continue;
                sb.append((char)c);
                cnt++;
            }
            return sb.toString();
        }
    }
    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        StringBuilder out = new StringBuilder();
        int T = fr.nextInt();
        final int LIMIT = 50000000;
        for (int tc = 0; tc < T; tc++) {
            int M = fr.nextInt();
            int C = fr.nextInt();
            int I = fr.nextInt();
            char[] code = fr.nextStringExact(C).toCharArray();
            char[] input = fr.nextStringExact(I).toCharArray();
            int[] match = new int[C];
            int[] stack = new int[C];
            int top = -1;
            for (int i = 0; i < C; i++) {
                if (code[i] == '[') {
                    stack[++top] = i;
                } else if (code[i] == ']') {
                    int j = stack[top--];
                    match[i] = j;
                    match[j] = i;
                }
            }
            int[] mem = new int[M];
            int ptr = 0;
            int ip = 0;
            int pc = 0;
            long executed = 0;
            while (pc < C && executed < LIMIT) {
                char cmd = code[pc];
                switch (cmd) {
                    case '-':
                        mem[ptr] = (mem[ptr] - 1) & 0xFF;
                        break;
                    case '+':
                        mem[ptr] = (mem[ptr] + 1) & 0xFF;
                        break;
                    case '<':
                        ptr = (ptr == 0) ? M - 1 : ptr - 1;
                        break;
                    case '>':
                        ptr = (ptr == M - 1) ? 0 : ptr + 1;
                        break;
                    case '[':
                        if (mem[ptr] == 0) pc = match[pc];
                        break;
                    case ']':
                        if (mem[ptr] != 0) pc = match[pc];
                        break;
                    case ',':
                        if (ip < I) mem[ptr] = input[ip++];
                        else mem[ptr] = 255;
                        break;
                    case '.':
                        break;
                }
                executed++;
                pc++;
            }
            if (pc >= C) {
                out.append("Terminates\n");
                continue;
            } else {
                boolean[] wasExecuted = new boolean[C + 1];
                int ran = 0;
                while (ran < LIMIT) {
                    wasExecuted[pc] = true;
                    char cmd = code[pc];
                    switch (cmd) {
                        case '-':
                            mem[ptr] = (mem[ptr] - 1) & 0xFF;
                            break;
                        case '+':
                            mem[ptr] = (mem[ptr] + 1) & 0xFF;
                            break;
                        case '<':
                            ptr = (ptr == 0) ? M - 1 : ptr - 1;
                            break;
                        case '>':
                            ptr = (ptr == M - 1) ? 0 : ptr + 1;
                            break;
                        case '[':
                            if (mem[ptr] == 0) pc = match[pc];
                            break;
                        case ']':
                            if (mem[ptr] != 0) pc = match[pc];
                            break;
                        case ',':
                            if (ip < I) mem[ptr] = input[ip++];
                            else mem[ptr] = 255;
                            break;
                        case '.':
                            break;
                    }
                    ran++;
                    pc++;
                    if (pc >= C) break;
                }
                int end = -1;
                for (int j = C - 1; j >= 0; j--) {
                    if (code[j] == ']' && wasExecuted[j] && !wasExecuted[j + 1]) {
                        end = j;
                        break;
                    }
                }
                int start = match[end];
                out.append("Loops ").append(start).append(" ").append(end).append("\n");
            }
        }
        System.out.print(out.toString());
    }
}