package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 9375 - 패션왕 신해빈
//  날짜 : 2026-01-16
// -------------------------------
public class Problem9375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());

            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());

                String wear = st.nextToken();
                String kind = st.nextToken();

                map.put(kind, map.getOrDefault(kind, 0) + 1);
            }

            int answer = 1;
            for (Integer value : map.values()) {
                int count = value + 1;

                answer *= count;
            }

            System.out.println(answer - 1);
        }
    }
}