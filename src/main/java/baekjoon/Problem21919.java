package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 21919 - 소수 최소 공배수
//  날짜 : 2026-02-04
// -------------------------------
public class Problem21919 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (isPrime(number)) {
                set.add(number);
            }
        }

        if (set.isEmpty()) {
            System.out.println(-1);
            return;
        }

        long answer = 1L;
        for (int i : set) {
            answer *= i;
        }

        System.out.println(answer);
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }


}