import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int rem = s.length() % 3;
        if(rem != 0) {
            StringBuilder pad = new StringBuilder();
            for(int i = 0; i < 3 - rem; i++){
                pad.append("0");
            }
            s = pad + s;
        }
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < s.length(); i += 3){
            int digit = (s.charAt(i)-'0')*4 + (s.charAt(i+1)-'0')*2 + (s.charAt(i+2)-'0');
            ans.append(digit);
        }
        System.out.println(ans);
    }
}