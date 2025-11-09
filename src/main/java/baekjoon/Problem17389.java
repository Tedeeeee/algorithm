package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 17389 - 보너스 점수
//  날짜 : 2025-11-08
// -------------------------------
public class Problem17389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int totalCount = Integer.parseInt(br.readLine());

        char[] list = br.readLine().toCharArray();

        int result = 0;
        int bonus = 0;
        for (int i = 0; i < totalCount; i++) {
            char c = list[i];

            if (c == 'X') {
                bonus = 0;
            }

            if (c == 'O') {
                int correctScore = i + 1;
                result = result + correctScore + bonus;
                bonus++;
            }
        }

        System.out.println(result);
    }
}
