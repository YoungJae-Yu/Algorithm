import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Double> grade = new HashMap<>();
        grade.put("A+", 4.5);
        grade.put("A0", 4.0);
        grade.put("B+", 3.5);
        grade.put("B0", 3.0);
        grade.put("C+", 2.5);
        grade.put("C0", 2.0);
        grade.put("D+", 1.5);
        grade.put("D0", 1.0);
        grade.put("F", 0.0);

        double totalGrade = 0;
        double totalCredit = 0;

        for (int i = 0; i < 20; i++) {
            String subject = sc.next();
            double credit = sc.nextDouble();
            String g = sc.next();

            if (!g.equals("P")) {
                totalGrade += grade.get(g) * credit;
                totalCredit += credit;
            }
        }

        System.out.printf("%.6f", totalGrade / totalCredit);
    }
}
