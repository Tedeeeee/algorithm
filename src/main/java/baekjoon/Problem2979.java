package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 2979 - 트럭 주차
//  날짜 : 2025-11-10
// -------------------------------
public class Problem2979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int truck = 3;

        int one = Integer.parseInt(st.nextToken());
        int two = Integer.parseInt(st.nextToken());
        int three = Integer.parseInt(st.nextToken());

        int[] arr = new int[101];
        for (int i = 0; i < truck; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = start; j < end; j++) {
                arr[j]++;
            }
        }

        int[] rate = new int[truck + 1];
        rate[1] = one;
        rate[2] = two * 2;
        rate[3] = three * 3;

        int result = 0;
        for (int i = 0; i <= 100; i++) {
            result += rate[arr[i]];
        }

        System.out.println(result);
    }

}
