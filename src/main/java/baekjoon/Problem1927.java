package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 1927 - 최소 힙
//  날짜 : 2026-01-29
// -------------------------------
public class Problem1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> qu = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                int poll = qu.isEmpty() ? 0 : qu.poll();
                sb.append(poll).append("\n");
            } else {
                qu.offer(num);
            }
        }

        System.out.print(sb);
    }
}
