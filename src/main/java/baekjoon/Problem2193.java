package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// -------------------------------
//  문제 : BOJ 2193 - 이친수
//  날짜 : 2026-01-14
// -------------------------------
public class Problem2193 {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 이친수는 0으로 시작하지 않는다
        // 1이 두번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로써 가지고 있지 않는다

        // n = 1 => 1개
        // 0 => 0개 (0)
        // 1 => 1개 (1)
        // n = 2 => 1개
        // 0 -> 1개 (10)
        // 1 -> 0개 (0)
        // n = 3 => 2개
        // 0 -> 1개 (100)
        // 1 -> 1개 (101)
        // n = 4 => 3개
        // 0 -> 2개 (1000, 1010)
        // 1 -> 1개 (1001)

        // 맨 뒷자리가 0인 경우는 그 어떤수가 와도 상관없다
        // 맨 뒷자리가 1인 경우는 0만 가능하다
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][2];

        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }

        System.out.println(dp[n][0] + dp[n][1]);

    }
}