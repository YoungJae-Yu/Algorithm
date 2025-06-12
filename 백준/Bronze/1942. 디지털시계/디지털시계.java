import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            String[] input = br.readLine().split(" ");
            String[] startTimeStr = input[0].split(":");
            String[] endTimeStr = input[1].split(":");

            int startH = Integer.parseInt(startTimeStr[0]);
            int startM = Integer.parseInt(startTimeStr[1]);
            int startS = Integer.parseInt(startTimeStr[2]);

            int endH = Integer.parseInt(endTimeStr[0]);
            int endM = Integer.parseInt(endTimeStr[1]);
            int endS = Integer.parseInt(endTimeStr[2]);

            int currentH = startH;
            int currentM = startM;
            int currentS = startS;

            int count = 0;

            while (true) {
                if ((currentH * 10000 + currentM * 100 + currentS) % 3 == 0) {
                    count++;
                }

                if (currentH == endH && currentM == endM && currentS == endS) {
                    break;
                }

                currentS++;
                if (currentS == 60) {
                    currentS = 0;
                    currentM++;
                    if (currentM == 60) {
                        currentM = 0;
                        currentH++;
                        if (currentH == 24) {
                            currentH = 0;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}
