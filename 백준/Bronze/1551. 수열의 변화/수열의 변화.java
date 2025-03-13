import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();
        String[] input = sc.nextLine().split(",");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        
        for (int k = 0; k < K; k++) {
            int[] temp = new int[arr.length - 1];
            for (int i = 0; i < arr.length - 1; i++) {
                temp[i] = arr[i + 1] - arr[i];
            }
            arr = temp;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(",");
            }
        }
        System.out.println(sb.toString());
    }
}