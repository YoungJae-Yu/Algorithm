import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.length() == 0) continue;
            StringTokenizer st = new StringTokenizer(line);
            int b = Integer.parseInt(st.nextToken());
            if (b == 0) break;
            String p = st.nextToken();
            String mStr = st.nextToken();
            int mVal = 0;
            for (int i = 0; i < mStr.length(); i++) {
                mVal = mVal * b + (mStr.charAt(i) - '0');
            }
            if (mVal == 0) {
                System.out.println(p);
                continue;
            }
            int rem = 0;
            for (int i = 0; i < p.length(); i++) {
                rem = (rem * b + (p.charAt(i) - '0')) % mVal;
            }
            if (rem == 0) {
                System.out.println(0);
                continue;
            }
            StringBuilder sb = new StringBuilder();
            while (rem > 0) {
                sb.append(rem % b);
                rem /= b;
            }
            System.out.println(sb.reverse().toString());
        }
    }
}