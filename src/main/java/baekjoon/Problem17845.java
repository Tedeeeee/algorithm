package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// -------------------------------
//  문제 : BOJ 17845 - 수강 과목
//  날짜 : 2026-01-30
// -------------------------------
public class Problem17845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 최대 공부 시간
        int n = Integer.parseInt(st.nextToken());
        // 과목 수
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[n + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            // 중요도
            int a = Integer.parseInt(st.nextToken());
            // 시간
            int b = Integer.parseInt(st.nextToken());

            for (int j = n; j >= b; j--) {
                dp[j] = Math.max(dp[j], dp[j - b] + a);
            }
        }

        System.out.println(dp[n]);

    }
}
