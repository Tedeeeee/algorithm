package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// -------------------------------
//  문제 : BOJ 2920 - 음계
//  날짜 : 2025-11-08
// -------------------------------
public class Problem2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strings = br.readLine().split(" ");

        int[] list = new int[8];
        for (int i = 0; i < 8; i++) {
            list[i] = Integer.parseInt(strings[i]);
        }

        boolean asc = true;
        boolean desc = true;

        for (int i = 1; i < 8; i++) {
            if (list[i] != list[i - 1] + 1) {
                asc = false;
            }
            if (list[i] != list[i - 1] - 1) {
                desc = false;
            }
        }

        if (asc) {
            System.out.println("ascending");
        } else if (desc) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
