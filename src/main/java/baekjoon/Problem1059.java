package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 1059 - 좋은 구간
//  날짜 : 2026-01-20
// -------------------------------
public class Problem1059 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // A와 B는 양의 정수이다. A < B 이다
        // A <= x <= B를 만족하는 모든 정수 x가 집합 S에 속하지 않는다
        int l = Integer.parseInt(br.readLine());
        int[] arr = new int[l];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < l; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int n = Integer.parseInt(br.readLine());

//        int min = 0;
//        int max = 0;
//        for (int i = 0; i < l - 1; i++) {
//            if (arr[i] == n) {
//                System.out.println(0);
//                return;
//            }
//
//            if (arr[i] < n && arr[i + 1] > n) {
//                min = arr[i];
//                max = arr[i + 1];
//            }
//        }

        for (int x : arr) {
            if (x == n) {
                System.out.println(0);
                return;
            }
        }

        int left = 0;
        int right = 0;
        for (int x : arr) {
            if (x > n) {
                right = x;
                break;
            }
            left = x;
        }

        // right 가 없다는건 좋은 구간이 아예 없다는 얘기
        if (right == 0) {
            System.out.println(0);
            return;
        }

//        int length = max - min - 1;
//        int[] range = new int[length];
//        int idx = 0;
//        for (int i = min + 1; i < max; i++) {
//            range[idx++] = i;
//        }
//
//        int answer = 0;
//        for (int i = 0; i < length - 1; i++) {
//            for (int j = i + 1; j < length; j++) {
//                if (range[i] <= n && range[j] >= n) {
//                    answer++;
//                }
//            }
//        }

        int answer = (n - left) * (right - n) - 1;
        System.out.println(answer);
    }
}