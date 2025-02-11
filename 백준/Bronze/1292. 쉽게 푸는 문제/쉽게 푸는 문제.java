import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        int num = 1;
        while(list.size() < b) {
            for(int i = 0; i < num && list.size() < b; i++){
                list.add(num);
            }
            num++;
        }
        int sum = 0;
        for(int i = a - 1; i < b; i++){
            sum += list.get(i);
        }
        System.out.println(sum);
    }
}