package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 10539 - 수빈이와 수열
//  날짜 : 2025-11-08
// -------------------------------
public class Problem10539 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxDivider = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int calc = 0;
        for (int i = 1; i <= maxDivider; i++) {
            int number = Integer.parseInt(st.nextToken());
            int origin = number * i - calc;

            System.out.print(origin + " ");

            calc += origin;
        }
    }

}
