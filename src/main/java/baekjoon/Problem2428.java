package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 2428 - 표절
//  날짜 : 2026-01-29
// -------------------------------
public class Problem2428 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long answer = 0;
        for (int i = 0; i < n; i++) {
            // 자신과 쌍을 만들지 못하게 1을 더해주어야 한다
            int left = i + 1;
            int right = n - 1;
            int best = i;

            long limit = (long) arr[i] * 10;

            while (left <= right) {
                int mid = (left + right) / 2;

                if ((long) arr[mid] * 9 <= limit) {
                    best = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            answer += (best - i);
        }

        System.out.println(answer);
    }
}
