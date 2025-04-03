import java.util.*;

public class Main { static Map<String, Character> codeMap = new HashMap<>();

static {
    codeMap.put("000000", 'A');
    codeMap.put("001111", 'B');
    codeMap.put("010011", 'C');
    codeMap.put("011100", 'D');
    codeMap.put("100110", 'E');
    codeMap.put("101001", 'F');
    codeMap.put("110101", 'G');
    codeMap.put("111010", 'H');
}

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    String S = sc.next();
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < N; i++) {
        String segment = S.substring(i * 6, (i + 1) * 6);
        if (codeMap.containsKey(segment)) {
            result.append(codeMap.get(segment));
        } else {
            boolean found = false;
            for (String key : codeMap.keySet()) {
                if (isOneBitDifferent(segment, key)) {
                    result.append(codeMap.get(key));
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println(i + 1);
                return;
            }
        }
    }
    System.out.println(result);
}

private static boolean isOneBitDifferent(String s1, String s2) {
    int diffCount = 0;
    for (int i = 0; i < 6; i++) {
        if (s1.charAt(i) != s2.charAt(i)) {
            diffCount++;
            if (diffCount > 1) {
                return false;
            }
        }
    }
    return diffCount == 1;
}

}

