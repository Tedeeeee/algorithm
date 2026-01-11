package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 1149 - RGB 거리
//  날짜 : 2026-01-11
// -------------------------------
public class Problem1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // RGB 거리엔 집이 n 개
        // 집을 R, G, B 중 하나로 칠해야한다
        // 모든 집을 칠하는 비용의 최솟값

        // 1. 1번 집의 색은 2번 집의 색과 같지 않아야 한다
        // 2. N번 집의 색은 N - 1 번 집의 색과 같지 않아야 한다
        // 3. i의 집은 양옆의 집의 색이 겹치면 안된다.

        // 집의 수
        int N = Integer.parseInt(br.readLine());

        // N 개의 줄에는 각 집을 칠하는 비용
        int[][] arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int r = arr[0][0];
        int g = arr[0][1];
        int b = arr[0][2];

        for (int i = 1; i < N; i++) {
            int nr = arr[i][0] + Math.min(g, b);
            int ng = arr[i][1] + Math.min(r, b);
            int nb = arr[i][2] + Math.min(r, g);
            r = nr;
            g = ng;
            b = nb;
        }

        int answer = Math.min(r, Math.min(g, b));
        System.out.println(answer);
    }
}
