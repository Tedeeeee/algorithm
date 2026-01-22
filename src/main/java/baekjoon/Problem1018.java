package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 1018 - 체스판 다시 칠하기
//  날짜 : 2026-01-22
// -------------------------------
public class Problem1018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        char[][] pan = new char[row][col];

        for (int i = 0; i < row; i++) {
            String s = br.readLine();
            for (int j = 0; j < col; j++) {
                pan[i][j] = s.charAt(j);
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < row - 7; i++) {
            for (int j = 0; j < col - 7; j++) {

                int cntW = 0;
                int cntB = 0;

                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {
                        // 오른쪽으로 몇 칸 움직였나
                        int rowMoving = k - i;
                        // 아래로 몇 칸 움직였나
                        int colMoving = l - j;

                        // 0 이면 짝수, 1이면 홀수
                        int parity = (rowMoving + colMoving) % 2;

                        // W 로 시작했을때, parity가 0이면 W, 1이면 B
                        char expectedW = (parity == 0) ? 'W' : 'B';
                        if (pan[k][l] != expectedW) {
                            cntW++;
                        }

                        // B 로 시작했을때, parity가 0이면 B, 1이면 W
                        char expectedB = (parity == 0) ? 'B' : 'W';
                        if (pan[k][l] != expectedB) {
                            cntB++;
                        }
                    }
                }

                answer = Math.min(answer, Math.min(cntB, cntW));
            }
        }

        System.out.println(answer);
    }
}