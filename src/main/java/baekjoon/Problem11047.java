package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 11047 - 동전 O
//  날짜 : 2025-12-22
// -------------------------------
public class Problem11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coin);

        int answer = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (m >= coin[i]) {
                answer += m / coin[i];

                m %= coin[i];
            }
        }

        System.out.println(answer);
    }
}
