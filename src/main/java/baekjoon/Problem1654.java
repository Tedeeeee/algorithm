package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 1654 - 랜선 자르기
//  날짜 : 2025-12-15
// -------------------------------
public class Problem1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] len = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            len[i] = num;

            max = Math.max(max, num);
        }

        long left = 1;
        long right = max;
        long answer = 0;
        while (left <= right) {
            long totalLenCnt = 0;
            long mid = (left + right) / 2;

            for (int i = 0; i < n; i++) {
                totalLenCnt += len[i] / mid;
            }

            if (totalLenCnt >= k) {
                answer = Math.max(mid, answer);
            }

            if (totalLenCnt < k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
