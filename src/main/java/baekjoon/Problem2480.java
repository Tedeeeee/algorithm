package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// -------------------------------
//  문제 : BOJ 2480 - 주사위 세개
//  날짜 : 2025-11-08
// -------------------------------
public class Problem2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] numbers = line.split(" ");

        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[1]);
        int c = Integer.parseInt(numbers[2]);

        int total = calcPrize(a, b, c);

        System.out.println(total);
    }

    private static int calcPrize(int a, int b, int c) {
        if (a == b && b == c) {
            return 10000 + a * 1000;
        }
        if (a == b || a == c) {
            return 1000 + a * 100;
        }
        if (b == c) {
            return 1000 + b * 100;
        }

        return Math.max(a, Math.max(b, c)) * 100;
    }
}
