package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// -------------------------------
//  문제 : BOJ 1302 - 베스트 셀러
//  날짜 : 2026-01-30
// -------------------------------
public class Problem1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int max = 0;
        String answer = "";
        for (String s : map.keySet()) {
            Integer i = map.get(s);

            if (i > max) {
                max = i;
                answer = s;
            }
        }

        System.out.println(answer);
    }
}
