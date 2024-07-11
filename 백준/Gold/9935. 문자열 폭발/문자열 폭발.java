import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        
        StringBuilder result = new StringBuilder();
        int bombLength = bomb.length();
        char lastBombChar = bomb.charAt(bombLength - 1);

        for (int i = 0; i < str.length(); i++) {
            result.append(str.charAt(i));

            if (result.length() >= bombLength && result.charAt(result.length() - 1) == lastBombChar) {
                boolean found = true;
                for (int j = 0; j < bombLength; j++) {
                    if (result.charAt(result.length() - bombLength + j) != bomb.charAt(j)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    result.setLength(result.length() - bombLength);
                }
            }
        }

        System.out.println(result.length() == 0 ? "FRULA" : result.toString());
    }
}