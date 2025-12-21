package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 2217 - 로프
//  날짜 : 2025-12-21
// -------------------------------
public class Problem2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int roofCnt = arr.length - i;
            int weight = arr[i] * roofCnt;

            answer = Math.max(weight, answer);
        }

        System.out.println(answer);
    }
}
