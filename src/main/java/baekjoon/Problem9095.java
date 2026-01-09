package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// -------------------------------
//  문제 : BOJ 9095 - 1,2,3 더하기
//  날짜 : 2026-01-09
// -------------------------------
public class Problem9095 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1 -> 1
        // 1

        // 2 -> 2
        // 1 + 1, 2

        // 3 -> 4
        // 1 + 1 + 1, 2 + 1, 1 + 2, 3

        // 4 -> 7
        // 1+1+1+1, 1+2+1, 2+1+1, 3+1 => (3)+1
        // 1+1+2, 2+2 => (2)+2
        // 1+3 => (1)+3
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < 12; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());
            sb.append(dp[target]).append("\n");
        }

        System.out.println(sb);
    }
}