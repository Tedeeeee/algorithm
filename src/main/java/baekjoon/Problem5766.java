package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// -------------------------------
//  문제 : BOJ 5766 - 할아버지는 유명해!
//  날짜 : 2025-02-01
// -------------------------------
public class Problem5766 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            int[] people = new int[10001];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) break;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    int number = Integer.parseInt(st.nextToken());
                    people[number]++;
                }
            }

            int max = 0;
            for (int i = 0; i < 10001; i++) {
                max = Math.max(max, people[i]);
            }

            for (int i = 0; i < 10001; i++) {
                if (people[i] == max) {
                    people[i] = 0;
                }
            }

            max = 0;
            for (int i = 0; i < 10001; i++) {
                max = Math.max(max, people[i]);
            }

            for (int i = 0; i < 10001; i++) {
                if (people[i] == max) {
                    sb.append(i).append(" ");
                }
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }
}
