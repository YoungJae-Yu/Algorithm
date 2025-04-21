import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, List<String>> info = new HashMap<>();

    public static void main(String[] args) throws IOException {
        init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (Q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int count = 0;
            for (int year = S; year <= E; year++) {
                List<String> list = info.get(year);
                if (list != null) {
                    count += list.size();
                }
            }
            sb.append(count).append("\n");
            for (int year = S; year <= E; year++) {
                List<String> list = info.get(year);
                if (list != null) {
                    for (String name : list) {
                        sb.append(year).append(" ").append(name).append("\n");
                    }
                }
            }
        }
        System.out.print(sb);
    }

    static void init() {
        info.put(1967, Arrays.asList("DavidBowie"));
        info.put(1969, Arrays.asList("SpaceOddity"));
        info.put(1970, Arrays.asList("TheManWhoSoldTheWorld"));
        info.put(1971, Arrays.asList("HunkyDory"));
        info.put(1972, Arrays.asList("TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars"));
        info.put(1973, Arrays.asList("AladdinSane", "PinUps"));
        info.put(1974, Arrays.asList("DiamondDogs"));
        info.put(1975, Arrays.asList("YoungAmericans"));
        info.put(1976, Arrays.asList("StationToStation"));
        info.put(1977, Arrays.asList("Low", "Heroes"));
        info.put(1979, Arrays.asList("Lodger"));
        info.put(1980, Arrays.asList("ScaryMonstersAndSuperCreeps"));
        info.put(1983, Arrays.asList("LetsDance"));
        info.put(1984, Arrays.asList("Tonight"));
        info.put(1987, Arrays.asList("NeverLetMeDown"));
        info.put(1993, Arrays.asList("BlackTieWhiteNoise"));
        info.put(1995, Arrays.asList("1.Outside"));
        info.put(1997, Arrays.asList("Earthling"));
        info.put(1999, Arrays.asList("Hours"));
        info.put(2002, Arrays.asList("Heathen"));
        info.put(2003, Arrays.asList("Reality"));
        info.put(2013, Arrays.asList("TheNextDay"));
        info.put(2016, Arrays.asList("BlackStar"));
    }
}