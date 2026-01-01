package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// -------------------------------
//  문제 : BOJ 13975 - 파일 합치기 3
//  날짜 : 2026-01-01
// -------------------------------
public class Problem13975 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int roof = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < roof; i++) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            Queue<Long> queue = new PriorityQueue<>();
            for (int j = 0; j < n; j++) {
                queue.add(Long.parseLong(st.nextToken()));
            }

            long sum = 0;
            while (queue.size() > 1) {
                long first = queue.poll();
                long second = queue.poll();
                long merge = first + second;
                sum += merge;
                queue.add(merge);
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}