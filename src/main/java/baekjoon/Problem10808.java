package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// -------------------------------
//  문제 : BOJ 10808 - 알파벳 갯수
//  날짜 : 2025-11-09
// -------------------------------
public class Problem10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] alphas = new int[26];

        char[] charArray = br.readLine().toLowerCase().toCharArray();

        for (char c : charArray) {
            alphas[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int c : alphas) {
            sb.append(c).append(" ");
        }

        System.out.println(sb.toString());
    }
}
