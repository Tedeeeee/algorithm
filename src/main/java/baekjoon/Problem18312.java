package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 18312 - 시각
//  날짜 : 2025-12-16
// -------------------------------
public class Problem18312 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int answer = 0;

        for (int h = 0; h <= N; h++) {
            for (int m = 0; m < 60; m++) {
                for (int s = 0; s < 60; s++) {
                    if (hasDigit(h, K) || hasDigit(m, K) || hasDigit(s, K)) {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean hasDigit(int x, int k) {
        return (x / 10 == k) || (x % 10 == k);
    }
}
