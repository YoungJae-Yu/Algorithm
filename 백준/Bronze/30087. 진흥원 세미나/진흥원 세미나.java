import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, String> seminarRooms = new HashMap<>();
        seminarRooms.put("Algorithm", "204");
        seminarRooms.put("DataAnalysis", "207");
        seminarRooms.put("ArtificialIntelligence", "302");
        seminarRooms.put("CyberSecurity", "B101");
        seminarRooms.put("Network", "303");
        seminarRooms.put("Startup", "501");
        seminarRooms.put("TestStrategy", "105");

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String seminar = scanner.nextLine();
            System.out.println(seminarRooms.get(seminar));
        }
    }
}