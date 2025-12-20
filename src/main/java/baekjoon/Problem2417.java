package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 2417 - 정수 제곱근
//  날짜 : 2025-12-20
// -------------------------------
public class Problem2417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        }

        long left = 0;
        long right = n;
        long answer = 0;
        while(left <= right) {
            long middle = (left + right) / 2;
            if(Math.pow(middle, 2) >= n) {
                answer = middle;
                right = middle - 1;
            }
            else if(Math.pow(middle, 2) < n){
                left = middle + 1;
            }
        }

        System.out.println(answer);
    }
}
