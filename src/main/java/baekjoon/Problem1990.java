package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// -------------------------------
//  문제 : BOJ 1990 - 소수인팰린드롬
//  날짜 : 2026-01-31
// -------------------------------
public class Problem1990 {

    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        prime = new boolean[end + 1];

        // 소수를 먼저 체크
        for (int i = 2; i <= Math.sqrt(end); i++) {
            if (!prime[i]) {
                int j = 2;

                while (i * j <= end) {
                    prime[i * j] = true;
                    j++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (!prime[i] && isPal(i)) {
                sb.append(i).append('\n');
            }
        }

        sb.append(-1);
        System.out.println(sb);
    }

    private static boolean isPal(int number) {
        int origin = number;
        int reverse = 0;

        while (number > 0) {
            reverse = reverse * 10 + (number % 10);
            number /= 10;
        }

        return origin == reverse;
    }
}
