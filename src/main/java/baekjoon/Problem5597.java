package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// -------------------------------
//  문제 : BOJ 5597 - 과제 안 내신 분..?
//  날짜 : 2025-11-11
// -------------------------------
public class Problem5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int studentCount = 30;
        int[] check = new int[studentCount + 1];

        for (int i = 0; i < 28; i++) {
            int studentNumber = Integer.parseInt(br.readLine());
            check[studentNumber]++;
        }

        for (int i = 1; i < check.length; i++) {
            if (check[i] == 0) {
                System.out.println(i);
            }
        }

    }
}
