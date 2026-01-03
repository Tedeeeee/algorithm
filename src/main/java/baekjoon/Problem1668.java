package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// -------------------------------
//  문제 : BOJ 1668 - 트로피 진열
//  날짜 : 2026-01-03
// -------------------------------
public class Problem1668 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int left = countVisible(arr, 0, n, 1);
        int right = countVisible(arr, n - 1, -1, -1);

        System.out.println(left);
        System.out.println(right);
    }

    private static int countVisible(int[] arr, int start, int end, int step) {
        int count = 0;
        int max = Integer.MIN_VALUE;

        for (int i = start; i != end; i += step) {
            if (arr[i] > max) {
                max = arr[i];
                count++;
            }
        }

        return count;
    }
}
