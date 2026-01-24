package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 20551 - Sort 마스터 배지훈의 후계자
//  날짜 : 2026-01-24
// -------------------------------
public class Problem20551 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 원소의 갯수
        int N = Integer.parseInt(st.nextToken());
        // 질문의 갯수
        int M = Integer.parseInt(st.nextToken());

        // 원소 배열
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 오름차순으로 정렬한 배열 B
        Arrays.sort(arr);

        // 질문 배열
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int question = Integer.parseInt(br.readLine());

            int left = 0;
            int right = N - 1;
            int answer = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (arr[mid] >= question) {
                    if (arr[mid] == question) {
                        answer = mid;
                    }
                    right = mid - 1;
                } else if (arr[mid] < question) {
                    left = mid + 1;
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);

    }
}
