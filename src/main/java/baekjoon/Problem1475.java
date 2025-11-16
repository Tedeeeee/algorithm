package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// -------------------------------
//  문제 : BOJ 1475 - 방 번호
//  날짜 : 2025-11-17
// -------------------------------
public class Problem1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int[] count = new int[9];

        for (int i = 0; i < s.length(); i++) {
            int number = s.charAt(i) - '0';

            if (number == 9) {
                count[6]++;
            } else {
                count[number]++;
            }
        }

        count[6] = (count[6] + 1) / 2;

        int result = 0;
        for (int cnt : count) {
            result = Math.max(cnt, result);
        }

        System.out.println(result);
    }
}
