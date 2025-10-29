import java.io.*;
public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();
        int totalR = 0, totalB = 0;
        for(char c : s.toCharArray()){
            if(c == 'R') totalR++;
            else totalB++;
        }
        if(totalR == 0 || totalB == 0){
            System.out.println(0);
            return;
        }
        int leftR = 0, leftB = 0, rightR = 0, rightB = 0;
        int i = 0;
        while(i < s.length() && s.charAt(i) == 'R'){ leftR++; i++; }
        i = 0;
        while(i < s.length() && s.charAt(i) == 'B'){ leftB++; i++; }
        i = s.length() - 1;
        while(i >= 0 && s.charAt(i) == 'R'){ rightR++; i--; }
        i = s.length() - 1;
        while(i >= 0 && s.charAt(i) == 'B'){ rightB++; i--; }
        int moveR = Math.min(totalR - leftR, totalR - rightR);
        int moveB = Math.min(totalB - leftB, totalB - rightB);
        System.out.println(Math.min(moveR, moveB));
    }
}