package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// -------------------------------
//  문제 : BOJ 1931 - 회의실 배정
//  날짜 : 2025-12-24
//  오해 : 문제는 회의실의 갯수가 아니라 회의를 가장 많이 하는 갯수를 고르는거였음
// -------------------------------
public class Problem1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr.add(new int[] {x, y});
        }

        arr.sort((o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int end = 0;
        int count = 0;
        for (int[] number : arr) {
            int start = number[0];
            if (start >= end) {
                count++;
                end = number[1];
            }
        }

        System.out.println(count);
    }
}
