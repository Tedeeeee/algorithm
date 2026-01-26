package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 11478 - 서로 다른 부분 문자열의 갯수
//  날짜 : 2026-01-26
// -------------------------------
public class Problem11478 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Set<String> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String substring = str.substring(i, j);
                set.add(substring);
            }
        }

        System.out.println(set.size());
    }
}