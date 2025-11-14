package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 1547 - 누울 자리를 찾아라
//  날짜 : 2025-11-14
// -------------------------------
public class Problem1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[][] arr = new char[n][n];

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        int horizontal = 0;

        for(int i = 0; i < n; i++){
            int emptySpace = 0;
            for (int j = 0; j < n; j++) {
                char x = arr[i][j];

                if (x == '.') {
                    emptySpace++;
                } else {
                    if (emptySpace >= 2) {
                        horizontal++;
                    }
                    emptySpace = 0;
                }


            }
            if (emptySpace >= 2) {
                horizontal++;
            }

        }

        int vertical = 0;
        for (int i = 0; i < n; i++) {
            int emptySpace = 0;
            for (int j = 0; j < n; j++) {
                char y = arr[j][i];

                if (y == '.') {
                    emptySpace++;
                } else {
                    if (emptySpace >= 2) {
                        vertical++;
                    }
                    emptySpace = 0;
                }
            }

            if (emptySpace >= 2) {
                vertical++;
            }
        }

        System.out.printf("%d %d", horizontal, vertical);
    }
}
