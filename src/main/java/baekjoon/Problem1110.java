package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 1110 - 더하기 사이클
//  날짜 : 2025-11-15
// -------------------------------
public class Problem1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] targetNumberArr = new int[2];

        if (n >= 10) {
            targetNumberArr[0] = n / 10;
        }
        targetNumberArr[1] = n % 10;

        int[] numberArr = new int[2];

        numberArr[0] = targetNumberArr[0];
        numberArr[1] = targetNumberArr[1];

        int result = 0;

        do {
            result++;
            int sum = numberArr[0] + numberArr[1];
            int next = (numberArr[1] * 10) + (sum % 10);

            numberArr[0] = next / 10;
            numberArr[1] = next % 10;
        } while (!Arrays.equals(numberArr, targetNumberArr));

        System.out.println(result);
    }
}
