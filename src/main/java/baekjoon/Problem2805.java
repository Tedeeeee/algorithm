package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 2805 - 나무 자르기
//  날짜 : 2025-12-18
// -------------------------------
public class Problem2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        int height = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            arr[i] = num;
            height = Math.max(height, num);
        }

        int left = 0;
        int maxHeight = 0;
        while (left <= height) {
            int mid = left + (height - left) / 2;

            long length = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] > mid) {
                    length += arr[i] - mid;
                }
            }

            if (length >= M) {
                maxHeight = mid;
                left = mid + 1;
            } else {
                height = mid - 1;
            }
        }

        System.out.println(maxHeight);
    }
}
