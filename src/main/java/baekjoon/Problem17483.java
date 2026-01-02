package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 17485 - 진우의 달 여행
//  날짜 : 2026-01-02
// -------------------------------
public class Problem17483 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int[][][] dp = new int[n][m][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DP의 최소값을 찾기 위해 초기화
        int init = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = init;
            }
        }

        // 시작값 채우기
        for (int i = 0; i < m; i++) {
            dp[0][i][0] = arr[0][i];
            dp[0][i][1] = arr[0][i];
            dp[0][i][2] = arr[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 목표 위치에 3개의 방향 중 가장 작은 값을 넣어야 한다
                // 한 번 왔던 길은 다시 갈 수 없다

                // 1. 왼쪽 상단 (기준값 i-1, j-1)
                // 이전의 수의 인덱스가 m의 범위를 벗어나면 안됨
                if (j - 1 >= 0) {
                    dp[i][j][0] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + arr[i][j];
                }

                // 2. 상단 (기준값 i-1, j)
                dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + arr[i][j];

                // 3. 오른쪽 상단 (기준값 i-1, j+1)
                // 이전의 수의 인덱스가 0보다 같거나 커야함
                if (j + 1 < m) {
                    dp[i][j][2] = Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + arr[i][j];
                }
            }
        }

        int answer = init;
        for (int i = 0; i < m; i++) {
            answer = Math.min(answer, dp[n - 1][i][0]);
            answer = Math.min(answer, dp[n - 1][i][1]);
            answer = Math.min(answer, dp[n - 1][i][2]);
        }

        System.out.println(answer);
    }
}
