package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 2839 - 설탕 배달
//  날짜 : 2026-01-21
// -------------------------------
public class Problem2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        int five = n / 5;
        int temp = n % 5;
        int answer = five;
        for (int i = 0; i < five; i++) {
            if (temp % 3 == 0) {
                break;
            }

            answer--;
            temp += 5;
        }

        if (temp % 3 != 0) {
            System.out.println(-1);
        } else {
            answer += temp / 3;
            System.out.println(answer);
        }

    }
}