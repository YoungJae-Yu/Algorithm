import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int P = sc.nextInt();
        
        Map<Integer, Integer> map = new HashMap<>();
        int value = N;
        int index = 0;

        while (!map.containsKey(value)) {
            map.put(value, index);
            value = (value * N) % P;
            index++;
        }

        System.out.println(index - map.get(value));
    }
}