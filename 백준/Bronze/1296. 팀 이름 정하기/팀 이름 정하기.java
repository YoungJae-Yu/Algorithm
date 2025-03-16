import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String myName = sc.next();
        int n = sc.nextInt();
        String bestTeam = "";
        int maxScore = -1;

        while (n-- > 0) {
            String teamName = sc.next();
            int score = calculateScore(myName, teamName);
            
            if (score > maxScore || (score == maxScore && teamName.compareTo(bestTeam) < 0)) {
                maxScore = score;
                bestTeam = teamName;
            }
        }
        
        System.out.println(bestTeam);
        sc.close();
    }

    private static int calculateScore(String myName, String teamName) {
        String combined = myName + teamName;
        int L = countChar(combined, 'L');
        int O = countChar(combined, 'O');
        int V = countChar(combined, 'V');
        int E = countChar(combined, 'E');

        return ((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100;
    }

    private static int countChar(String str, char ch) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == ch) count++;
        }
        return count;
    }
}