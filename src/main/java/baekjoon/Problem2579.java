package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 2579 - 계단 오르기
//  날짜 : 2026-01-10
// -------------------------------
public class Problem2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(stairs[1]);
            return;
        }

        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];

        if (n == 2) {
            System.out.println(dp[2]);
            return;
        }

        dp[3] = Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]);
        for (int i = 4; i <= n; i++) {
            // 2계단 전
            int firstCase = dp[i - 2] + stairs[i];
            // 이전 계단의 전전계단 + 이전 계단 + 목표 계단
            int secondCase = dp[i - 3] + stairs[i - 1] + stairs[i];
            dp[i] = Math.max(firstCase, secondCase);
        }

        System.out.println(dp[n]);
    }
}
