package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 10870 - 피보나치 수 5
//  날짜 : 2026-01-25
// -------------------------------
public class Problem10870 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new int[21];

        dp[1] = 1;
        dp[2] = 1;

        int answer = recursion(n);
        System.out.println(answer);
    }

    private static int recursion(int target) {
        if (target <= 1) {
            return dp[target];
        } else if (dp[target] != 0) {
            return dp[target];
        }

        return dp[target] = recursion(target - 1) + recursion(target - 2);
    }
}