package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 2577 - 숫자의 개수
//  날짜 : 2025-11-13
// -------------------------------
public class Problem2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int total = A * B * C;

        int[] numberCount = new int[10];

        while (total > 0) {
            int i = total % 10;

            numberCount[i]++;

            total /= 10;
        }

        for (int i : numberCount) {
            System.out.println(i);
        }
    }
}
