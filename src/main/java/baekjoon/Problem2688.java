package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// -------------------------------
//  문제 : BOJ 2688 - 줄어들지 않아
//  날짜 : 2026-01-21
// -------------------------------
public class Problem2688 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[65][10];

        for (int i = 0; i <= 9; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= 64; i++) {
            for (int j = 0; j <= 9; j++) {
                long sum = 0;
                for (int k = 0; k <= j; k++) {
                    sum += dp[i - 1][k];
                }
                dp[i][j] = sum;
            }
        }

        for (int i = 0; i < n; i++) {
            int digit = Integer.parseInt(br.readLine());
            System.out.println(dp[digit][9]);
        }
    }
}