package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// -------------------------------
//  문제 : BOJ 1913 - 달팽이
//  날짜 : 2025-12-27
// -------------------------------
public class Problem1913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[][] arr = new  int[n][n];

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};


        int x = n / 2;
        int y = n / 2;

        arr[x][y] = 1;

        int targetX = 0;
        int targetY = 0;

        if (target == 1) {
            targetX = 1;
            targetY = 1;
        }

        /**
         *  문제의 포인트는 좌회전을 했을때 값이 없으면 좌회전을 해도 된다는거
         */
        int arrow = 0;
        for (int i = 2; i <= n * n; i++) {
            // 현재 진행 방향
            x += dx[arrow];
            y += dy[arrow];

            arr[x][y] = i;

            if (i == target) {
                targetX = x + 1;
                targetY = y + 1;
            }

            // 좌회전 해보기
            int rightArrow = (arrow + 1) % 4;
            int nx = x + dx[rightArrow];
            int ny = y + dy[rightArrow];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] == 0) {
                arrow = rightArrow;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] line : arr) {
            for (int number : line) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
        }

        sb.append(targetX).append(" ").append(targetY);

        System.out.println(sb);
    }
}
