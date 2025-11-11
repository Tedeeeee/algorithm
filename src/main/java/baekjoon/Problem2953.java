package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 2953 - 나는 요리사다
//  날짜 : 2025-11-11
// -------------------------------
public class Problem2953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int person = 5;
        int checkList = 4;

        int winnerIndex = 0;
        int winnerScore = Integer.MIN_VALUE;
        for (int i = 0; i < person; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int j = 0; j < checkList; j++) {
                sum += Integer.parseInt(st.nextToken());
            }
            //
            if (sum > winnerScore) {
                winnerIndex = i + 1;
                winnerScore = sum;
            }
        }

        System.out.printf("%d %d", winnerIndex, winnerScore);


    }
}
