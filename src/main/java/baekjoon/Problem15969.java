package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 15969 - 행복
//  날짜 : 2025-11-08
//  추가 설명 : 제일 큰 값과 제일 작은 값을 찾는 것이기에 정렬이 필요 없다는 생각이 들었음
// -------------------------------
public class Problem15969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] list = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, list[i]);
            min = Math.min(min, list[i]);
        }

        System.out.println(max - min);
    }
}
