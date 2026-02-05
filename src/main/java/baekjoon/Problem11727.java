package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 11727 - 2xn 타일링 2
//  날짜 : 2026-02-05
// -------------------------------
public class Problem11727 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 2x1의 경우는 n - 1 칸 까지 들어간 경우의 수
        // 1x2,2x2의 경우에는 n - 2칸까지 들어간 경우의 수
        // 3가지의 경우의 수를 모두 더해야한다

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        if (n == 0 || n == 1) {
            System.out.println(dp[n] % 10007);
            return;
        }

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + (2 * dp[i - 2])) % 10007;
        }

        System.out.println(dp[n]);
    }
}