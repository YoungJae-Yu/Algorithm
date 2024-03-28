import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Member {
    int age;
    String name;
    int joinOrder; // 가입한 순서를 저장할 필드

    public Member(int age, String name, int joinOrder) {
        this.age = age;
        this.name = name;
        this.joinOrder = joinOrder;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 회원의 수 N
        List<Member> members = new ArrayList<>(); // 회원을 저장할 리스트

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int age = Integer.parseInt(input[0]);
            String name = input[1];
            members.add(new Member(age, name, i)); // 나이, 이름, 가입 순서를 저장
        }

        // 나이 순으로 정렬하고, 나이가 같으면 가입한 순서대로 정렬
        Collections.sort(members, (m1, m2) -> {
            if (m1.age == m2.age) {
                return Integer.compare(m1.joinOrder, m2.joinOrder); // 가입한 순서대로 정렬
            } else {
                return Integer.compare(m1.age, m2.age); // 나이 순으로 정렬
            }
        });

        // 정렬된 회원 정보 출력
        members.forEach(member -> System.out.println(member.age + " " + member.name));
    }
}
