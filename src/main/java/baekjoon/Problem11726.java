package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 11726 - 2xn 타일링
//  날짜 : 2026-01-17
// -------------------------------
public class Problem11726 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        if (n >= 1) {
            dp[1] = 1;
        }
        if (n >= 2) {
            dp[2] = 2;
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}