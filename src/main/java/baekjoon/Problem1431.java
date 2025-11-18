package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// -------------------------------
//  문제 : BOJ 1431 - 시리얼 번호
//  날짜 : 2025-11-18
//  추가 설명 : 해당 문제는 다양한 정렬 조건이 존재하여 comparator 를 사용한 비교 정렬 사용
// -------------------------------
public class Problem1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }

        Arrays.sort(str, (a, b) -> {
            // 길이 순서 비교하기
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }

            // 더한 값 비교하기
            int sumA = sumDigit(a);
            int sumB = sumDigit(b);

            if (sumA != sumB) {
                return sumA - sumB;
            }

            // 사전 비교
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }

    private static int sumDigit(String str) {
        int sum = 0;
        for (char c : str.toCharArray()) {
            if (c >= '0' && c <= '9') {
                sum += c - '0';
            }
        }

        return sum;
    }
}
