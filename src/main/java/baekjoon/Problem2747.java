package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// -------------------------------
//  문제 : BOJ 2747 - 피보나치 수
//  날짜 : 2025-11-08
// -------------------------------
public class Problem2747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());

        int[] list = new int[number + 1];

        list[0] = 0;
        list[1] = 1;

        for (int i = 2; i < number + 1; i++) {
            list[i] = list[i - 1] + list[i - 2];
        }

        System.out.println(list[number]);
    }
}
