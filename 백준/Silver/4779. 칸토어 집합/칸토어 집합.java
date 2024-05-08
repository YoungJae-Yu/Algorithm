import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNextInt()) {
            int N = sc.nextInt();
            System.out.println(cantorSet(N));
        }
        
        sc.close();
    }
    
    public static String cantorSet(int N) {
        // 3^N 길이의 문자열 배열을 생성하고, 모두 '-'로 초기화한다.
        char[] set = new char[(int)Math.pow(3, N)];
        for(int i = 0; i < set.length; i++) {
            set[i] = '-';
        }
        
        // 칸토어 집합을 만든다.
        makeCantorSet(set, 0, set.length, N);
        
        return new String(set);
    }
    
    public static void makeCantorSet(char[] set, int start, int end, int depth) {
        if(depth == 0) {
            return;
        }
        
        // 구간을 3등분하여 가운데 구간을 공백(' ')으로 바꾼다.
        int third = (end - start) / 3;
        for(int i = start + third; i < start + 2 * third; i++) {
            set[i] = ' ';
        }
        
        // 남은 두 선(문자열)에 대해 재귀적으로 함수를 호출한다.
        makeCantorSet(set, start, start + third, depth - 1);
        makeCantorSet(set, start + 2 * third, end, depth - 1);
    }
}
