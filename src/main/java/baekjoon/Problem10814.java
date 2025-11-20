package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 10814 - 나이순 정렬
//  날짜 : 2025-11-20
// -------------------------------
public class Problem10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Person[] person = new Person[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            person[i] = new Person(age, name, i);
        }

        Arrays.sort(person);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            Person people = person[i];

            sb.append(people.age).append(" ").append(people.name).append("\n");
        }

        System.out.println(sb);

    }

    static class Person implements Comparable<Person> {

        int age;
        String name;
        int order;

        public Person(int age, String name, int order) {
            this.age = age;
            this.name = name;
            this.order = order;
        }

        @Override
        public int compareTo(Person o) {
            if (age != o.age) {
                return age - o.age;
            }
            return order - o.order;
        }
    }
}
