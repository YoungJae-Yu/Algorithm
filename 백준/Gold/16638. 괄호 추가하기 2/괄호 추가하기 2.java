import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int max;
    static String[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        max = Integer.MIN_VALUE;
        arr = new String[N];
        String input = br.readLine();
        for (int i = 0; i < input.length(); ++i) {
            arr[i] = input.charAt(i) + "";
        }
        int operCnt = N / 2;
        int target = operCnt % 2 == 0 ? operCnt / 2 : (operCnt / 2) + 1;
        calculate(null);
        for (int R = 1; R <= target; ++R) {
            find(0, 1, R, new int[R]);
        }
        System.out.println(max);
    }
    static void calculate(int[] select) {
        String[] nowArr = new String[N];
        for (int i = 0; i < N; ++i)
            nowArr[i] = arr[i];
        if (select != null) {
            for (int i = 0; i < select.length; ++i) {
                if (select[i] != 0) {
                    int selIdx = select[i];
                    int front = selIdx - 1;
                    int back = selIdx + 1;
                    int val = 0;
                    switch (nowArr[selIdx]) {
                    case "+":
                        val = Integer.parseInt(nowArr[front]) + Integer.parseInt(nowArr[back]);
                        break;
                    case "-":
                        val = Integer.parseInt(nowArr[front]) - Integer.parseInt(nowArr[back]);
                        break;
                    case "*":
                        val = Integer.parseInt(nowArr[front]) * Integer.parseInt(nowArr[back]);
                        break;
                    }
                    nowArr[selIdx] = Integer.toString(val);
                    nowArr[front] = nowArr[back] = null;
                }
            }
        }
        for (int i = 1; i < N; i += 2) {
            if (nowArr[i]!=null&&nowArr[i].equals("*")) {
                int L = i - 1, R = i + 1;
                while (L - 1 > 0 && nowArr[L] == null)
                    --L;
                while (R + 1 < N && nowArr[R] == null)
                    ++R;
                nowArr[i] = Integer.toString(Integer.parseInt(nowArr[L]) * Integer.parseInt(nowArr[R]));
                nowArr[L] = nowArr[R] = null;
            }
        }
        for (int i = 1; i < N; i += 2) {
            if (nowArr[i]==null) continue;
            if (nowArr[i].equals("+") || nowArr[i].equals("-")) {
                int L = i - 1, R = i + 1;
                while (L - 1 > 0 && nowArr[L] == null)
                    --L;
                while (R + 1 < N && nowArr[R] == null)
                    ++R;
                if(nowArr[i].equals("+")) {
                    nowArr[i] = Integer.toString(Integer.parseInt(nowArr[L]) + Integer.parseInt(nowArr[R]));
                }else if(nowArr[i].equals("-")) {
                    nowArr[i] = Integer.toString(Integer.parseInt(nowArr[L]) - Integer.parseInt(nowArr[R]));
                }
                nowArr[L] = nowArr[R] = null;
            }
        }
        int sum = 0;
        for (int i = 0; i < N; ++i) {
            if (nowArr[i] != null)
                sum += Integer.parseInt(nowArr[i]);
        }
        max = Math.max(max, sum);
    }
    static void find(int cnt, int start, int R, int[] select) {
        if (cnt == R) {
            calculate(select);
            return;
        }
        for (int i = start; i < N; i += 2) {
            if (cnt > 0 && (select[cnt - 1] + 2) == i)
                continue;
            select[cnt] = i;
            find(cnt + 1, i + 2, R, select);
        }
    }
}