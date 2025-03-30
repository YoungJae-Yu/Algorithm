import java.util.*;

public class Main { public static void main(String[] args) { Scanner sc = new Scanner(System.in); int n = sc.nextInt(); String[] channels = new String[n];

for (int i = 0; i < n; i++) {
        channels[i] = sc.next();
    }
    
    int kbs1Index = 0, kbs2Index = 0;
    for (int i = 0; i < n; i++) {
        if (channels[i].equals("KBS1")) {
            kbs1Index = i;
        } else if (channels[i].equals("KBS2")) {
            kbs2Index = i;
        }
    }
    
    for (int i = 0; i < kbs1Index; i++) {
        System.out.print("1");
    }
    for (int i = kbs1Index; i > 0; i--) {
        System.out.print("4");
    }
    
    if (kbs1Index > kbs2Index) {
        kbs2Index++;
    }
    
    for (int i = 0; i < kbs2Index; i++) {
        System.out.print("1");
    }
    for (int i = kbs2Index; i > 1; i--) {
        System.out.print("4");
    }
}

}

