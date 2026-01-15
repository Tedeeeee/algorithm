package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 21921 - 블로그
//  날짜 : 2026-01-15
// -------------------------------
public class Problem21921 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[x];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < x; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        int max = sum;
        int answer = 1;

        for (int i = n; i < x; i++) {
            sum += arr[i] - arr[i - n];

            if (sum > max) {
                max = sum;
                answer = 1;
            } else if (sum == max) {
                answer++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(answer);
        }
    }
}