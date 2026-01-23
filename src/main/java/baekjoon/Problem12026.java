package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 12026 - BOJ 거리
//  날짜 : 2026-01-23
// -------------------------------
public class Problem12026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        // 현재 위치로 올 수 있는 최소의 값을 확인해야 한다
        for (int i = 1; i < n; i++) {
            // 현 위치 전의 값들을 확인하기
            for (int j = 0; j < i; j++) {
                if (dp[j] == Integer.MAX_VALUE) {
                    continue;
                }
                // 이전에 있는 값이 현 위치 전에 있어야 하는 단어만 체크
                if (!canMove(arr[j], arr[i])) {
                    continue;
                }

                int k = i - j;
                dp[i] = Math.min(dp[i], dp[j] + (k * k));
            }
        }

        int answer = dp[n - 1];
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static boolean canMove(char x, char y) {
        return (x == 'B' && y == 'O')
                || (x == 'O' && y == 'J')
                || (x == 'J' && y == 'B');
    }
}
