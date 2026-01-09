package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// -------------------------------
//  문제 : BOJ 1463 - 1로 만들기
//  날짜 : 2026-01-08
// -------------------------------
public class Problem1463 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            // 3번을 통해 값을 셋팅
            dp[i] = dp[i - 1] + 1;

            // 위엔 무조건 값이 하나 들어가고
            // 2의 배수인 경우 / 2의 값에 경우의 수와 비교
            // 더 작은수
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            // 여기도 마찬가지
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}
