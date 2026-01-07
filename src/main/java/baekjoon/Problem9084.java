package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 9084 - 동전
//  날짜 : 2026-01-07
// -------------------------------
public class Problem9084 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1, 5, 10, 50, 100, 500
        // 이 동전으로 정수의 금액을 만들 수 있다

        // 테스트 케이스의 수
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            // 동전 가짓 수
            int n = Integer.parseInt(br.readLine());
            // 동전 순서
            int[] arr = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            // 목표 금액
            int m = Integer.parseInt(br.readLine());
            // 0 부터 m 까지 만들 수 있는 갯수
            // 중요한 것은 목표하는 금액을 만드는 방법의 갯수를 미리 작성해 놓는 것이다.
            int[] dp = new int[m + 1];
            dp[0] = 1;

            // 코인의 배수만큼 진행되어야 한다
            for (int coin : arr) {
                for (int k = coin; k <= m; k++) {
                    // 포인트는 코인이 더해지기 전의 값에 있다.
                    // 시작은 코인의 값으로 시작해되 그 이후에는 해당 코인의 이후 값을 만드는 방법의 갯수를 확인한다
                    dp[k] += dp[k - coin];
                }
            }

            System.out.println(dp[m]);

        }
    }
}
