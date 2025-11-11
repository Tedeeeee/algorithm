package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 1547 - 공
//  날짜 : 2025-11-11
// -------------------------------
public class Problem1547 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int change = Integer.parseInt(br.readLine());

        int ballNumber = 1;

        StringTokenizer st;
        for (int i = 0; i < change; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x == ballNumber) {
                ballNumber = y;
            } else if (y == ballNumber) {
                ballNumber = x;
            }
        }

        System.out.println(ballNumber);

    }
}
