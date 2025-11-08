import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] used = new boolean[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] words = line.split(" ");
            boolean assigned = false;
            int searchFrom = 0;
            for (int w = 0; w < words.length && !assigned; w++) {
                if (words[w].length() == 0) {
                    searchFrom += 1;
                    continue;
                }
                char c = words[w].charAt(0);
                char lower = Character.toLowerCase(c);
                if (lower >= 'a' && lower <= 'z' && !used[lower - 'a']) {
                    used[lower - 'a'] = true;
                    int pos = line.indexOf(words[w], searchFrom);
                    StringBuilder cur = new StringBuilder(line);
                    cur.insert(pos + 1, "]");
                    cur.insert(pos, "[");
                    sb.append(cur.toString()).append('\n');
                    assigned = true;
                }
                searchFrom += words[w].length() + 1;
            }
            if (assigned) continue;
            for (int j = 0; j < line.length() && !assigned; j++) {
                char c = line.charAt(j);
                char lower = Character.toLowerCase(c);
                if (lower >= 'a' && lower <= 'z' && !used[lower - 'a']) {
                    used[lower - 'a'] = true;
                    StringBuilder cur = new StringBuilder(line);
                    cur.insert(j + 1, "]");
                    cur.insert(j, "[");
                    sb.append(cur.toString()).append('\n');
                    assigned = true;
                }
            }
            if (!assigned) sb.append(line).append('\n');
        }
        System.out.print(sb.toString());
    }
}